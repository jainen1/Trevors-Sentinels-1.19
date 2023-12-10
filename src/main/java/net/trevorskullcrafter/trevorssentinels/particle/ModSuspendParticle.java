package net.trevorskullcrafter.trevorssentinels.particle;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.particle.*;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particle.DefaultParticleType;
import net.trevorskullcrafter.trevorssentinels.util.TextUtil;

public class ModSuspendParticle extends SpriteBillboardParticle {
    ModSuspendParticle(ClientWorld clientWorld, double d, double e, double f, double g, double h, double i) {
        super(clientWorld, d, e, f, g, h, i);
        float j = this.random.nextFloat() * 0.1F + 0.2F;
        this.red = j;
        this.green = j;
        this.blue = j;
        this.setBoundingBoxSpacing(0.02F, 0.02F);
        this.scale *= this.random.nextFloat() * 0.6F + 0.5F;
        this.velocityX *= 0.019999999552965164;
        this.velocityY *= 0.019999999552965164;
        this.velocityZ *= 0.019999999552965164;
        this.maxAge = (int)(20.0 / (Math.random() * 0.8 + 0.2));
    }

    public ParticleTextureSheet getType() { return ParticleTextureSheet.PARTICLE_SHEET_TRANSLUCENT; }

    public void move(double dx, double dy, double dz) {
        this.setBoundingBox(this.getBoundingBox().offset(dx, dy, dz));
        this.repositionFromBoundingBox();
    }

    public void tick() {
        this.prevPosX = this.x;
        this.prevPosY = this.y;
        this.prevPosZ = this.z;
        if (this.maxAge-- <= 0) {
            this.markDead();
        } else {
            this.move(this.velocityX, this.velocityY, this.velocityZ);
            this.velocityX *= 0.99;
            this.velocityY *= 0.99;
            this.velocityZ *= 0.99;
        }
    }

    @Environment(EnvType.CLIENT)
    public static class FleshPusFactory implements ParticleFactory<DefaultParticleType> {
        private final SpriteProvider spriteProvider;
        public FleshPusFactory(SpriteProvider spriteProvider) { this.spriteProvider = spriteProvider; }

        public Particle createParticle(DefaultParticleType defaultParticleType, ClientWorld clientWorld, double d, double e, double f, double g, double h, double i) {
            ModSuspendParticle suspendParticle = new ModSuspendParticle(clientWorld, d, e, f, g, h, i);
            suspendParticle.setColor(TextUtil.FLESH_PUS.getRGBComponents(null)[0],
                    TextUtil.FLESH_PUS.getRGBComponents(null)[1], TextUtil.FLESH_PUS.getRGBComponents(null)[2]);
            suspendParticle.setSprite(this.spriteProvider);
            suspendParticle.setAlpha(1.0F - ((float) clientWorld.random.nextBetween(70, 100) / 10) * 0.09F);
            //suspendParticle.setMaxAge(suspendParticle.getMaxAge() / 2);
            return suspendParticle;
        }
    }
}