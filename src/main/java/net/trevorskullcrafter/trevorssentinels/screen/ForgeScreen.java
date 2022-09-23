package net.trevorskullcrafter.trevorssentinels.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.render.GameRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import static net.trevorskullcrafter.trevorssentinels.trevorssentinels.MOD_ID;

public class ForgeScreen extends HandledScreen<ForgeScreenHandler>{
    private static final Identifier TEXTURE = new Identifier(MOD_ID, "textures/gui/forge.png");
    public ForgeScreen(ForgeScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
    }

    @Override
    protected void init(){
        super.init();
        titleX = (backgroundWidth - textRenderer.getWidth(title)) / 2;
    }
    @Override
    protected void drawBackground(MatrixStack matrices, float delta, int mouseX, int mouseY) {
        RenderSystem.setShader(GameRenderer::getPositionShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - backgroundWidth) / 2;
        int y = (height - backgroundHeight) / 2;
        drawTexture(matrices, x, y, 0, 0, backgroundWidth, backgroundHeight);

        renderProgressArrow(matrices, x, y);
    }

    private void renderProgressArrow(MatrixStack matrices, int x, int y){
        if(handler.isCrafting()){
            drawTexture(matrices, x + 90, y + 20, 178, 0, 23, handler.getScaledProgress());
            drawTexture(matrices, x + 8, y + 19, 178, 0, 13, handler.getScaledFuel());
        }
    }

    @Override
    public void render(MatrixStack matrices, int mouseX, int mouseY, float delta){
        renderBackground(matrices);
        super.render(matrices, mouseX, mouseY, delta);
        drawMouseoverTooltip(matrices, mouseX, mouseY);
    }
}