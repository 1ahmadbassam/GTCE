package gregtech.integration.jei.recipe.fuel;

import gregtech.api.recipes.recipes.FuelRecipe;
import gregtech.api.util.LocalisationUtils;
import mezz.jei.api.ingredients.IIngredients;
import mezz.jei.api.recipe.IRecipeWrapper;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fluids.FluidStack;

public class GTFuelRecipeWrapper implements IRecipeWrapper {

    public final FuelRecipe recipe;

    public GTFuelRecipeWrapper(FuelRecipe recipe) {
        this.recipe = recipe;
    }

    @Override
    public void getIngredients(IIngredients ingredients) {
        ingredients.setInput(FluidStack.class, recipe.getRecipeFluid());
    }

    @Override
    public void drawInfo(Minecraft minecraft, int recipeWidth, int recipeHeight, int mouseX, int mouseY) {
        int duration = recipe.getDuration();
        long voltage = recipe.getMinVoltage();
        minecraft.fontRenderer.drawString(LocalisationUtils.format("gregtech.recipe.total", voltage * duration), 0, 70, 0x111111);
        minecraft.fontRenderer.drawString(LocalisationUtils.format("gregtech.recipe.eu_inverted", voltage), 0, 80, 0x111111);
        minecraft.fontRenderer.drawString(LocalisationUtils.format("gregtech.recipe.duration", duration / 20.0), 0, 90, 0x111111);
    }
}
