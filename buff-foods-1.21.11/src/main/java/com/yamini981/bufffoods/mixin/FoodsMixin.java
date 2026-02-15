package com.yamini981.bufffoods.mixin;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.food.Foods;

import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Foods.class)
public abstract class FoodsMixin {
	
	@Shadow @Final @Mutable
	private static FoodProperties PUMPKIN_PIE;

	@Inject(method="<clinit>", at = @At("TAIL"))
	private static void modifyPumpkinPie(CallbackInfo ci) {
		PUMPKIN_PIE = new FoodProperties.Builder().nutrition(8).saturationModifier(0.9F).build();
	}
}