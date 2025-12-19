package com.protons.testmod.world.gen.densityfunction;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.dynamic.CodecHolder;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.gen.densityfunction.DensityFunction;

public class CustomWorleyNoise implements DensityFunction {

    // 这个值决定了我们的“基础”稀疏度。值越小，基础就越稀疏。
    // 我们可以把它设为一个很小的值，比如 0.0001
    private static final double MASTER_SCALE = 0.0001;

    private final double scaleMultiplier;
    private final long seed;

    public static final MapCodec<CustomWorleyNoise> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(
                    Codec.doubleRange(0.1, 10.0).fieldOf("frequency_multiplier").orElse(1.0).forGetter(CustomWorleyNoise::getScaleMultiplier),
                    Codec.LONG.fieldOf("seed").forGetter(CustomWorleyNoise::getSeed)
            ).apply(instance, CustomWorleyNoise::new)
    );

    public static final CodecHolder<CustomWorleyNoise> CODEC_HOLDER = CodecHolder.of(CODEC);

    // 构造函数
    public CustomWorleyNoise(double scaleMultiplier, long seed) {
        this.scaleMultiplier = scaleMultiplier;
        this.seed = seed;
    }

    @Override
    public double sample(NoisePos pos) {
        // 最终的缩放值 = 内部基础缩放 * JSON传入的乘数
        final double finalScale = MASTER_SCALE * this.scaleMultiplier;

        double scaledX = pos.blockX() * finalScale;
        double scaledZ = pos.blockZ() * finalScale;

        int cellX = MathHelper.floor(scaledX);
        int cellZ = MathHelper.floor(scaledZ);

        double fracX = scaledX - cellX;
        double fracZ = scaledZ - cellZ;

        double minDistanceSq = Double.MAX_VALUE;

        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int neighborCellX = cellX + i;
                int neighborCellZ = cellZ + j;

                Random random = Random.create(this.seed + (long)neighborCellX * 3439 + (long)neighborCellZ * 147);
                double pointX = random.nextDouble();
                double pointZ = random.nextDouble();

                double dx = (i + pointX) - fracX;
                double dz = (j + pointZ) - fracZ;
                double distSq = dx * dx + dz * dz;

                if (distSq < minDistanceSq) {
                    minDistanceSq = distSq;
                }
            }
        }

        return (Math.sqrt(minDistanceSq) * 1.5) - 1.0;
    }

    public double getScaleMultiplier() { return scaleMultiplier; }
    public long getSeed() { return seed; }

    // ... minValue, maxValue, etc. ...
    @Override public void fill(double[] densities, EachApplier applier) { applier.fill(densities, this); }
    @Override public CodecHolder<? extends DensityFunction> getCodecHolder() { return CODEC_HOLDER; }
    @Override public double minValue() { return -1.0; }
    @Override public double maxValue() { return 0.5; }
    @Override public DensityFunction apply(DensityFunction.DensityFunctionVisitor visitor) { return this; }
}
