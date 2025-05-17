package net.meowing.renderlib;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import org.lwjgl.opengl.GL11;
import org.lwjgl.util.glu.Cylinder;
import org.lwjgl.util.glu.Disk;
import org.lwjgl.util.glu.GLU;
import org.lwjgl.util.glu.Sphere;

public class RenderLib {
	private static final Minecraft mc = Minecraft.getMinecraft();
	private static final RenderManager renderManager = mc.getRenderManager();
	private static final Tessellator tessellator = Tessellator.getInstance();
	private static final WorldRenderer worldRenderer = tessellator.getWorldRenderer();
	private static final Sphere sphere = new Sphere();
	private static final Cylinder cylinder = new Cylinder();
	private static final Disk disk = new Disk();

	public static void drawEspBox(double x, double y, double z, double w, double h, float red, float green, float blue, float alpha, boolean phase) {
		GlStateManager.pushMatrix();
		GL11.glLineWidth(2.0F);
		GlStateManager.disableCull();
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GlStateManager.depthMask(false);
		GlStateManager.disableTexture2D();
		if (phase) GlStateManager.disableDepth();
		GlStateManager.tryBlendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
		GlStateManager.translate(x - w / 2 - renderManager.viewerPosX, y - renderManager.viewerPosY, z - w / 2 - renderManager.viewerPosZ);
		GlStateManager.color(red, green, blue, alpha);
		worldRenderer.begin(GL11.GL_LINE_STRIP, DefaultVertexFormats.POSITION_TEX);
		worldRenderer.pos(0, 0, 0).endVertex();
		worldRenderer.pos(w, 0, 0).endVertex();
		worldRenderer.pos(w, h, 0).endVertex();
		worldRenderer.pos(0, h, 0).endVertex();
		worldRenderer.pos(w, h, 0).endVertex();
		worldRenderer.pos(w, h, w).endVertex();
		worldRenderer.pos(0, h, w).endVertex();
		worldRenderer.pos(w, h, w).endVertex();
		worldRenderer.pos(w, 0, w).endVertex();
		worldRenderer.pos(0, 0, w).endVertex();
		worldRenderer.pos(0, h, w).endVertex();
		worldRenderer.pos(0, h, 0).endVertex();
		worldRenderer.pos(0, 0, 0).endVertex();
		worldRenderer.pos(0, 0, w).endVertex();
		worldRenderer.pos(w, 0, w).endVertex();
		worldRenderer.pos(w, 0, 0).endVertex();
		tessellator.draw();
		GlStateManager.color(1F, 1F, 1F, 1F);
		GlStateManager.enableCull();
		GlStateManager.disableBlend();
		GlStateManager.depthMask(true);
		GlStateManager.enableTexture2D();
		if (phase) GlStateManager.enableDepth();
		GlStateManager.popMatrix();
	}

	public static void drawInnerEspBox(double x, double y, double z, double w, double h, float red, float green, float blue, float alpha, boolean phase) {
		GlStateManager.pushMatrix();
		GL11.glLineWidth(2.0F);
		GlStateManager.disableCull();
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GlStateManager.depthMask(false);
		GlStateManager.disableTexture2D();
		if (phase) GlStateManager.disableDepth();
		GlStateManager.tryBlendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
		GlStateManager.translate(x - w / 2 - renderManager.viewerPosX, y - renderManager.viewerPosY, z - w / 2 - renderManager.viewerPosZ);
		GlStateManager.color(red, green, blue, alpha);
		worldRenderer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION);
		worldRenderer.pos(w, 0, w).endVertex();
		worldRenderer.pos(w, 0, 0).endVertex();
		worldRenderer.pos(0, 0, 0).endVertex();
		worldRenderer.pos(0, 0, w).endVertex();
		worldRenderer.pos(w, h, w).endVertex();
		worldRenderer.pos(w, h, 0).endVertex();
		worldRenderer.pos(0, h, 0).endVertex();
		worldRenderer.pos(0, h, w).endVertex();
		worldRenderer.pos(0, h, w).endVertex();
		worldRenderer.pos(0, h, 0).endVertex();
		worldRenderer.pos(0, 0, 0).endVertex();
		worldRenderer.pos(0, 0, w).endVertex();
		worldRenderer.pos(w, h, w).endVertex();
		worldRenderer.pos(w, h, 0).endVertex();
		worldRenderer.pos(w, 0, 0).endVertex();
		worldRenderer.pos(w, 0, w).endVertex();
		worldRenderer.pos(w, h, 0).endVertex();
		worldRenderer.pos(0, h, 0).endVertex();
		worldRenderer.pos(0, 0, 0).endVertex();
		worldRenderer.pos(w, 0, 0).endVertex();
		worldRenderer.pos(0, h, w).endVertex();
		worldRenderer.pos(w, h, w).endVertex();
		worldRenderer.pos(w, 0, w).endVertex();
		worldRenderer.pos(0, 0, w).endVertex();
		tessellator.draw();
		GlStateManager.color(1F, 1F, 1F, 1F);
		GlStateManager.enableCull();
		GlStateManager.disableBlend();
		GlStateManager.depthMask(true);
		GlStateManager.enableTexture2D();
		if (phase) GlStateManager.enableDepth();
		GlStateManager.popMatrix();
	}

	public static void drawBaritoneEspBox(double x, double y, double z, double w, double h, float red, float green, float blue, float alpha, boolean phase) {
		GlStateManager.pushMatrix();
		GL11.glLineWidth(2.0F);
		GlStateManager.disableCull();
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GlStateManager.depthMask(false);
		GlStateManager.disableTexture2D();
		if (phase) GlStateManager.disableDepth();
		double th = h / 2 + Math.cos((((java.lang.System.nanoTime() / 100000.0) % 20000) / 20000) * Math.PI * 2) / (2 / h);
		double bh = h / 2 + Math.cos((((java.lang.System.nanoTime() / 100000.0) % 20000) / 20000) * Math.PI * 2) / -(2 / h);
		GlStateManager.tryBlendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
		GlStateManager.translate(x - w / 2 - renderManager.viewerPosX, y - renderManager.viewerPosY, z - w / 2 - renderManager.viewerPosZ);
		GlStateManager.color(red, green, blue, alpha);
		worldRenderer.begin(GL11.GL_LINE_STRIP, DefaultVertexFormats.POSITION_TEX);
		worldRenderer.pos(0, 0, 0).endVertex();
		worldRenderer.pos(0, h, 0).endVertex();
		worldRenderer.pos(0, th, 0).endVertex();
		worldRenderer.pos(w, th, 0).endVertex();
		worldRenderer.pos(w, 0, 0).endVertex();
		worldRenderer.pos(w, h, 0).endVertex();
		worldRenderer.pos(w, th, 0).endVertex();
		worldRenderer.pos(w, th, w).endVertex();
		worldRenderer.pos(w, 0, w).endVertex();
		worldRenderer.pos(w, h, w).endVertex();
		worldRenderer.pos(w, th, w).endVertex();
		worldRenderer.pos(0, th, w).endVertex();
		worldRenderer.pos(0, 0, w).endVertex();
		worldRenderer.pos(0, h, w).endVertex();
		worldRenderer.pos(0, th, w).endVertex();
		worldRenderer.pos(0, th, 0).endVertex();
		worldRenderer.pos(0, bh, 0).endVertex();
		worldRenderer.pos(w, bh, 0).endVertex();
		worldRenderer.pos(w, bh, w).endVertex();
		worldRenderer.pos(0, bh, w).endVertex();
		worldRenderer.pos(0, bh, 0).endVertex();
		tessellator.draw();
		GlStateManager.color(1F, 1F, 1F, 1F);
		GlStateManager.enableCull();
		GlStateManager.disableBlend();
		GlStateManager.depthMask(true);
		GlStateManager.enableTexture2D();
		if (phase) GlStateManager.enableDepth();
		GlStateManager.popMatrix();
	}

	public static void drawSphere(double x, double y, double z, float radius, int slices, int stacks, float rot1, float rot2, float rot3, float r, float g, float b, float a, boolean phase, boolean linemode) {
		x -= renderManager.viewerPosX;
		y -= renderManager.viewerPosY;
		z -= renderManager.viewerPosZ;
		GlStateManager.pushMatrix();
		GL11.glLineWidth(2.0F);
		GlStateManager.disableCull();
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GlStateManager.depthMask(false);
		GlStateManager.disableTexture2D();
		if (phase) GlStateManager.disableDepth();
		GlStateManager.color(r, g, b, a);
		GlStateManager.translate(x, y, z);
		GlStateManager.rotate(rot1, 1, 0, 0);
		GlStateManager.rotate(rot2, 0, 0, 1);
		GlStateManager.rotate(rot3, 0, 1, 0);
		sphere.setDrawStyle(linemode ? GLU.GLU_LINE : GLU.GLU_FILL);
		sphere.draw(radius, slices, stacks);
		GlStateManager.enableCull();
		GlStateManager.disableBlend();
		GlStateManager.depthMask(true);
		GlStateManager.enableTexture2D();
		if (phase) GlStateManager.enableDepth();
		GlStateManager.popMatrix();
	}

	public static void drawCyl(double x, double y, double z, float baseRadius, float topRadius, float height, int slices, int stacks, float rot1, float rot2, float rot3, float r, float g, float b, float a, boolean phase, boolean linemode) {
		x -= renderManager.viewerPosX;
		y -= renderManager.viewerPosY;
		z -= renderManager.viewerPosZ;
		GlStateManager.pushMatrix();
		GL11.glLineWidth(2.0F);
		GlStateManager.disableCull();
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GlStateManager.depthMask(false);
		GlStateManager.disableTexture2D();
		if (phase) GlStateManager.disableDepth();
		GlStateManager.color(r, g, b, a);
		GlStateManager.translate(x, y, z);
		GlStateManager.rotate(rot1, 1, 0, 0);
		GlStateManager.rotate(rot2, 0, 0, 1);
		GlStateManager.rotate(rot3, 0, 1, 0);
		cylinder.setDrawStyle(linemode ? GLU.GLU_LINE : GLU.GLU_FILL);
		cylinder.draw(baseRadius, topRadius, height, slices, stacks);
		GlStateManager.enableCull();
		GlStateManager.disableBlend();
		GlStateManager.depthMask(true);
		GlStateManager.enableTexture2D();
		if (phase) GlStateManager.enableDepth();
		GlStateManager.popMatrix();
	}

	public static void drawDisk(double x, double y, double z, float innerRadius, float outerRadius, int slices, int loops, float rot1, float rot2, float rot3, float r, float g, float b, float a, boolean phase, boolean linemode) {
		x -= renderManager.viewerPosX;
		y -= renderManager.viewerPosY;
		z -= renderManager.viewerPosZ;
		GlStateManager.pushMatrix();
		GL11.glLineWidth(2.0F);
		GlStateManager.disableCull();
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GlStateManager.depthMask(false);
		GlStateManager.disableTexture2D();
		if (phase) GlStateManager.disableDepth();
		GlStateManager.color(r, g, b, a);
		GlStateManager.translate(x, y, z);
		GlStateManager.rotate(rot1, 1, 0, 0);
		GlStateManager.rotate(rot2, 0, 0, 1);
		GlStateManager.rotate(rot3, 0, 1, 0);
		disk.setDrawStyle(linemode ? GLU.GLU_LINE : GLU.GLU_FILL);
		disk.draw(innerRadius, outerRadius, slices, loops);
		GlStateManager.enableCull();
		GlStateManager.disableBlend();
		GlStateManager.depthMask(true);
		GlStateManager.enableTexture2D();
		if (phase) GlStateManager.enableDepth();
		GlStateManager.popMatrix();
	}

	public static void drawEspBoxV2(double x, double y, double z, double wx, double h, double wz, float red, float green, float blue, float alpha, boolean phase) {
		drawEspBoxV2(x, y, z, wx, h, wz, red, green, blue, alpha, phase, 2.0F);
	}

	public static void drawEspBoxV2(double x, double y, double z, double wx, double h, double wz, float red, float green, float blue, float alpha, boolean phase, float lineWidth) {
		GlStateManager.pushMatrix();
		GL11.glLineWidth(lineWidth);
		GlStateManager.disableCull();
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GlStateManager.depthMask(false);
		GlStateManager.disableTexture2D();
		if (phase) GlStateManager.disableDepth();
		GlStateManager.tryBlendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
		GlStateManager.translate(x - wx / 2 - renderManager.viewerPosX, y - renderManager.viewerPosY, z - wz / 2 - renderManager.viewerPosZ);
		GlStateManager.color(red, green, blue, alpha);
		worldRenderer.begin(GL11.GL_LINE_STRIP, DefaultVertexFormats.POSITION_TEX);
		worldRenderer.pos(0, 0, 0).endVertex();
		worldRenderer.pos(wx, 0, 0).endVertex();
		worldRenderer.pos(wx, h, 0).endVertex();
		worldRenderer.pos(0, h, 0).endVertex();
		worldRenderer.pos(wx, h, 0).endVertex();
		worldRenderer.pos(wx, h, wz).endVertex();
		worldRenderer.pos(0, h, wz).endVertex();
		worldRenderer.pos(wx, h, wz).endVertex();
		worldRenderer.pos(wx, 0, wz).endVertex();
		worldRenderer.pos(0, 0, wz).endVertex();
		worldRenderer.pos(0, h, wz).endVertex();
		worldRenderer.pos(0, h, 0).endVertex();
		worldRenderer.pos(0, 0, 0).endVertex();
		worldRenderer.pos(0, 0, wz).endVertex();
		worldRenderer.pos(wx, 0, wz).endVertex();
		worldRenderer.pos(wx, 0, 0).endVertex();
		tessellator.draw();
		GlStateManager.color(1F, 1F, 1F, 1F);
		GlStateManager.enableCull();
		GlStateManager.disableBlend();
		GlStateManager.depthMask(true);
		GlStateManager.enableTexture2D();
		if (phase) GlStateManager.enableDepth();
		GlStateManager.popMatrix();
	}

	public static void drawInnerEspBoxV2(double x, double y, double z, double wx, double h, double wz, float red, float green, float blue, float alpha, boolean phase) {
		GlStateManager.pushMatrix();
		GL11.glLineWidth(2.0F);
		GlStateManager.disableCull();
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GlStateManager.depthMask(false);
		GlStateManager.disableTexture2D();
		if (phase) GlStateManager.disableDepth();
		GlStateManager.tryBlendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
		GlStateManager.translate(x - wx / 2 - renderManager.viewerPosX, y - renderManager.viewerPosY, z - wz / 2 - renderManager.viewerPosZ);
		worldRenderer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION);
		GlStateManager.color(red, green, blue, alpha);
		worldRenderer.pos(wx, 0, wz).endVertex();
		worldRenderer.pos(wx, 0, 0).endVertex();
		worldRenderer.pos(0, 0, 0).endVertex();
		worldRenderer.pos(0, 0, wz).endVertex();
		worldRenderer.pos(wx, h, wz).endVertex();
		worldRenderer.pos(wx, h, 0).endVertex();
		worldRenderer.pos(0, h, 0).endVertex();
		worldRenderer.pos(0, h, wz).endVertex();
		worldRenderer.pos(0, h, wz).endVertex();
		worldRenderer.pos(0, h, 0).endVertex();
		worldRenderer.pos(0, 0, 0).endVertex();
		worldRenderer.pos(0, 0, wz).endVertex();
		worldRenderer.pos(wx, h, wz).endVertex();
		worldRenderer.pos(wx, h, 0).endVertex();
		worldRenderer.pos(wx, 0, 0).endVertex();
		worldRenderer.pos(wx, 0, wz).endVertex();
		worldRenderer.pos(wx, h, 0).endVertex();
		worldRenderer.pos(0, h, 0).endVertex();
		worldRenderer.pos(0, 0, 0).endVertex();
		worldRenderer.pos(wx, 0, 0).endVertex();
		worldRenderer.pos(0, h, wz).endVertex();
		worldRenderer.pos(wx, h, wz).endVertex();
		worldRenderer.pos(wx, 0, wz).endVertex();
		worldRenderer.pos(0, 0, wz).endVertex();
		tessellator.draw();
		GlStateManager.color(1F, 1F, 1F, 1F);
		GlStateManager.enableCull();
		GlStateManager.disableBlend();
		GlStateManager.depthMask(true);
		GlStateManager.enableTexture2D();
		if (phase) GlStateManager.enableDepth();
		GlStateManager.popMatrix();
	}

	public static void drawBaritoneEspBoxV2(double x, double y, double z, double wx, double h, double wz, float red, float green, float blue, float alpha, boolean phase) {
		drawBaritoneEspBoxV2(x, y, z, wx, h, wz, red, green, blue, alpha, phase, 2.0F);
	}

	public static void drawBaritoneEspBoxV2(double x, double y, double z, double wx, double h, double wz, float red, float green, float blue, float alpha, boolean phase, float lineWidth) {
		GlStateManager.pushMatrix();
		GL11.glLineWidth(lineWidth);
		GlStateManager.disableCull();
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GlStateManager.depthMask(false);
		GlStateManager.disableTexture2D();
		if (phase) GlStateManager.disableDepth();
		double th = h / 2 + Math.cos((((java.lang.System.nanoTime() / 100000.0) % 20000) / 20000) * Math.PI * 2) / (2 / h);
		double bh = h / 2 + Math.cos((((java.lang.System.nanoTime() / 100000.0) % 20000) / 20000) * Math.PI * 2) / -(2 / h);
		GlStateManager.tryBlendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
		GlStateManager.translate(x - wx / 2 - renderManager.viewerPosX, y - renderManager.viewerPosY, z - wz / 2 - renderManager.viewerPosZ);
		GlStateManager.color(red, green, blue, alpha);
		worldRenderer.begin(GL11.GL_LINE_STRIP, DefaultVertexFormats.POSITION_TEX);
		worldRenderer.pos(0, 0, 0).endVertex();
		worldRenderer.pos(0, h, 0).endVertex();
		worldRenderer.pos(0, th, 0).endVertex();
		worldRenderer.pos(wx, th, 0).endVertex();
		worldRenderer.pos(wx, 0, 0).endVertex();
		worldRenderer.pos(wx, h, 0).endVertex();
		worldRenderer.pos(wx, th, 0).endVertex();
		worldRenderer.pos(wx, th, wz).endVertex();
		worldRenderer.pos(wx, 0, wz).endVertex();
		worldRenderer.pos(wx, h, wz).endVertex();
		worldRenderer.pos(wx, th, wz).endVertex();
		worldRenderer.pos(0, th, wz).endVertex();
		worldRenderer.pos(0, 0, wz).endVertex();
		worldRenderer.pos(0, h, wz).endVertex();
		worldRenderer.pos(0, th, wz).endVertex();
		worldRenderer.pos(0, th, 0).endVertex();
		worldRenderer.pos(0, bh, 0).endVertex();
		worldRenderer.pos(wx, bh, 0).endVertex();
		worldRenderer.pos(wx, bh, wz).endVertex();
		worldRenderer.pos(0, bh, wz).endVertex();
		worldRenderer.pos(0, bh, 0).endVertex();
		tessellator.draw();
		GlStateManager.color(1F, 1F, 1F, 1F);
		GlStateManager.enableCull();
		GlStateManager.disableBlend();
		GlStateManager.depthMask(true);
		GlStateManager.enableTexture2D();
		if (phase) GlStateManager.enableDepth();
		GlStateManager.popMatrix();
	}

	public static void drawInnerBaritoneEspBoxV2(double x, double y, double z, double wx, double h, double wz, float red, float green, float blue, float alpha, boolean phase) {
		GlStateManager.pushMatrix();
		GL11.glLineWidth(2.0F);
		GlStateManager.disableCull();
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GlStateManager.depthMask(false);
		GlStateManager.disableTexture2D();
		if (phase) GlStateManager.disableDepth();
		double th = h / 2 + Math.cos((((java.lang.System.nanoTime() / 100000.0) % 20000) / 20000) * Math.PI * 2) / (2 / h);
		double bh = h / 2 + Math.cos((((java.lang.System.nanoTime() / 100000.0) % 20000) / 20000) * Math.PI * 2) / -(2 / h);
		GlStateManager.tryBlendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
		GlStateManager.translate(x - wx / 2 - renderManager.viewerPosX, y - renderManager.viewerPosY, z - wz / 2 - renderManager.viewerPosZ);
		worldRenderer.begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION);
		GlStateManager.color(red, green, blue, alpha);
		worldRenderer.pos(wx, th, wz).endVertex();
		worldRenderer.pos(wx, th, 0).endVertex();
		worldRenderer.pos(0, th, 0).endVertex();
		worldRenderer.pos(0, th, wz).endVertex();
		worldRenderer.pos(wx, bh, wz).endVertex();
		worldRenderer.pos(wx, bh, 0).endVertex();
		worldRenderer.pos(0, bh, 0).endVertex();
		worldRenderer.pos(0, bh, wz).endVertex();
		worldRenderer.pos(0, bh, wz).endVertex();
		worldRenderer.pos(0, bh, 0).endVertex();
		worldRenderer.pos(0, th, 0).endVertex();
		worldRenderer.pos(0, th, wz).endVertex();
		worldRenderer.pos(wx, bh, wz).endVertex();
		worldRenderer.pos(wx, bh, 0).endVertex();
		worldRenderer.pos(wx, th, 0).endVertex();
		worldRenderer.pos(wx, th, wz).endVertex();
		worldRenderer.pos(wx, bh, 0).endVertex();
		worldRenderer.pos(0, bh, 0).endVertex();
		worldRenderer.pos(0, th, 0).endVertex();
		worldRenderer.pos(wx, th, 0).endVertex();
		worldRenderer.pos(0, bh, wz).endVertex();
		worldRenderer.pos(wx, bh, wz).endVertex();
		worldRenderer.pos(wx, th, wz).endVertex();
		worldRenderer.pos(0, th, wz).endVertex();
		tessellator.draw();
		GlStateManager.color(1F, 1F, 1F, 1F);
		GlStateManager.enableCull();
		GlStateManager.disableBlend();
		GlStateManager.depthMask(true);
		GlStateManager.enableTexture2D();
		if (phase) GlStateManager.enableDepth();
		GlStateManager.popMatrix();
	}

	public static void drawLine(double x1, double y1, double z1, double x2, double y2, double z2, float red, float green, float blue, float alpha, boolean phase) {
		drawLine(x1, y1, z1, x2, y2, z2, red, green, blue, alpha, phase, 2.0F);
	}

	public static void drawLine(double x1, double y1, double z1, double x2, double y2, double z2, float red, float green, float blue, float alpha, boolean phase, float lineWidth) {
		GlStateManager.pushMatrix();
		GL11.glLineWidth(lineWidth);
		GlStateManager.disableCull();
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GlStateManager.depthMask(false);
		GlStateManager.disableTexture2D();
		if (phase) GlStateManager.disableDepth();
		GlStateManager.tryBlendFuncSeparate(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, 1, 0);
		GlStateManager.translate(-renderManager.viewerPosX, -renderManager.viewerPosY, -renderManager.viewerPosZ);
		worldRenderer.begin(GL11.GL_LINE_STRIP, DefaultVertexFormats.POSITION);
		GlStateManager.color(red, green, blue, alpha);
		worldRenderer.pos(x1, y1, z1).endVertex();
		worldRenderer.pos(x2, y2, z2).endVertex();
		tessellator.draw();
		GlStateManager.color(1F, 1F, 1F, 1F);
		GlStateManager.enableCull();
		GlStateManager.disableBlend();
		GlStateManager.depthMask(true);
		GlStateManager.enableTexture2D();
		if (phase) GlStateManager.enableDepth();
		GlStateManager.popMatrix();
	}
}
