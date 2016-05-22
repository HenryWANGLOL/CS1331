import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
import java.util.function.Function;

public class Bakery {

    // private static class RecipeComparatorByYummyFactor implements Comparator<Recipe>{
    //     public int compare(Recipe r1, Recipe r2) {
    //         return Double.compare(r2.getYummyFactor(), r1.getYummyFactor());
    //     }  
    // }
    
    public static void main(String[] args) {
        Recipe pumpkinPie = new Recipe(110, "Pumpkin Pie", "Johnny Pumpkinseed");
        Recipe cookiesUpFront = new Recipe(14, "Cookies up front", "Amanda Moreton");
        Recipe chocolateCake = new Recipe(30, "chocolate Cake", "Dr Cakeman");
        Recipe lazagna = new Recipe(30.5, "Lazagna", "Dr Cakeman");
        Recipe browniesFromAFewWeeksAgo = new Recipe(Double.MAX_VALUE, "Brownies", "Amanda Moreton");
        Recipe[] recipes = new Recipe[]
            {pumpkinPie, cookiesUpFront, chocolateCake, lazagna, browniesFromAFewWeeksAgo};
        List<Recipe> ourRecipes = Arrays.asList(recipes);

        System.out.println("Before sorting:");
        System.out.println(ourRecipes);

        //method references
        Comparator<Recipe> functionalHotness 
            = Comparator
                .comparing(Recipe::getOB)
                .thenComparing(Recipe::getYummyFactor);


        // //inner class
        // Collections.sort(ourRecipes, new RecipeComparatorByYummyFactor());

        // //anonymous inner class
        // Collections.sort(ourRecipes, new Comparator<Recipe>() {
        //     public int compare(Recipe r1, Recipe r2) {
        //         return Double.compare(r2.getYummyFactor(), r1.getYummyFactor());
        //     }
        // });

        // //lambda
        // Collections.sort(ourRecipes, (r1, r2) -> {
        //     return Double.compare(r2.getYummyFactor(), r1.getYummyFactor());
        // });


        Collections.sort(ourRecipes, functionalHotness);

        System.out.println("After sorting:");
        System.out.println(ourRecipes);




    }

}