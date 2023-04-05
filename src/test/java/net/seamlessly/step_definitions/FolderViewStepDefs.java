package net.seamlessly.step_definitions;

import com.google.common.base.CharMatcher;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.seamlessly.pages.FolderViewPage;
import net.seamlessly.utility.BrowserUtility;
import net.seamlessly.utility.Driver;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.*;

public class FolderViewStepDefs {
FolderViewPage folderViewPage=new FolderViewPage();


    @When("user click the Name button")
    public void user_click_the_name_button() {
        BrowserUtility.sleep(2);
        folderViewPage.NamesFolder.click();

    }

    @When("Verify user can see the folder in alphabetic older based on their names")
    public void verify_user_can_see_the_folder_in_alphabetic_older_based_on_their_names() {

        List<WebElement> files = Driver.getDriver().findElements(By.xpath("//*[@data-type=\"dir\"]"));
        List<String> namesActual = new ArrayList<>();


        for (WebElement each : files) {

            namesActual.add(each.getAttribute("data-file").toLowerCase());

        }
        System.out.println("namesActual = " + namesActual);

        String expectedOrderByAscending="sort-indicator icon-triangle-n";
        String expectedOrderByDescending="sort-indicator icon-triangle-s";
        String actualOrder=folderViewPage.sortIndicatorIcon.getAttribute("class");



        if (actualOrder.equals(expectedOrderByAscending)){

            String[] names = namesActual.toArray(new String[0]);
            Arrays.sort(names);
            System.out.println("names = " + Arrays.toString(names));

            List<String> sortedNames = Arrays.asList(names);
            System.out.println("sortedNames = " + sortedNames);

            Assert.assertEquals(sortedNames,namesActual);


        } else if (actualOrder.equals(expectedOrderByDescending)) {

            String[] names = namesActual.toArray(new String[0]);
            Arrays.sort(names);
            List<String> sortedNames = Arrays.asList(names);
            System.out.println("sortedNames2 = " + sortedNames);

            Collections.reverse(sortedNames);
            String[] descend = sortedNames.toArray(new String[0]);
            System.out.println("descend = " + Arrays.toString(descend));

            List<String> descendNames = Arrays.asList(descend);

            Assert.assertEquals(descendNames,namesActual);

        }
    }

    @Then("verify after clicking the name if it is on ascending order or descending order")
    public void verify_after_clicking_the_name_if_it_is_on_ascending_order_or_descending_order() {


        String expectedOrderByAscending = "sort-indicator icon-triangle-n";
        String expectedOrderByDescending = "sort-indicator icon-triangle-s";
        String actualOrder = folderViewPage.sortIndicatorIcon.getAttribute("class");
        System.out.println("actualOrderByAscending = " + actualOrder);
        System.out.println("expectedOrderByAscending = " + expectedOrderByAscending);
        if (actualOrder.equals(expectedOrderByAscending)) {
            Assert.assertEquals(expectedOrderByAscending, actualOrder);
        } else if (actualOrder.equals(expectedOrderByDescending)) {

            Assert.assertEquals(expectedOrderByDescending, actualOrder);

        }


    }


    @When("user click the Size button")
    public void userClickTheSizeButton() {
        BrowserUtility.sleep(2);
        folderViewPage.headerSize.click();
    }

    @When("Verify user can see the folder in order based on their sizes")
    public void verifyUserCanSeeTheFolderInOrderBasedOnTheirSizes() {

        List<WebElement> files = Driver.getDriver().findElements(By.xpath("(//tbody[@id='fileList'])[1]//tr"));
        List<Integer> sizeActual = new ArrayList<>();
       /* List<Integer> x =  new ArrayList<Integer>();
        int[] n = (int[])x.toArray(int[x.size()]);*/

        for (WebElement each : files) {

            sizeActual.add(Integer.valueOf(each.getAttribute("data-size")));

        }

        String expectedOrderByAscending="sort-indicator icon-triangle-n";
        String expectedOrderByDescending="sort-indicator icon-triangle-s";
        String actualOrder=folderViewPage.sizeSortIndicator.getAttribute("class");
        System.out.println("actualOrder = " + actualOrder);



        if (actualOrder.equals(expectedOrderByAscending)){
/* List<Integer> x =  new ArrayList<Integer>();
        int[] n = (int[])x.toArray(int[x.size()]);
        Integer[] n = x.toArray(new Integer[0]);*/

            Integer[] sizes = sizeActual.toArray(new Integer[0]);
            Arrays.sort(sizes);
            System.out.println("sizes = " + Arrays.toString(sizes));

            List<Integer> sortedSizes = Arrays.asList(sizes);
            System.out.println("sortedsizes = " + sortedSizes);

            Assert.assertEquals(sortedSizes,sizeActual);


        } else if (actualOrder.equals(expectedOrderByDescending)) {

            Integer[] sizes = sizeActual.toArray(new Integer[0]);
            Arrays.sort(sizes);
            System.out.println("sizes = " + Arrays.toString(sizes));

            List<Integer> sortedSizes = Arrays.asList(sizes);
            System.out.println("sortedSizes = " + sortedSizes);

            Collections.reverse(sortedSizes);
            Integer[] descend = sortedSizes.toArray(new Integer[0]);
            System.out.println("descend = " + Arrays.toString(descend));

            List<Integer> descendSizes = Arrays.asList(descend);

            Assert.assertEquals(descendSizes,sizeActual);

        }
    }

    @And("user click the Modified button")
    public void userClickTheModifiedButton() {
BrowserUtility.sleep(2);
folderViewPage.headerDate.click();
    }

    @Then("Verify user can see the folder in order based on their uploaded dates")
    public void verifyUserCanSeeTheFolderInOrderBasedOnTheirUploadedDates() {

        List<WebElement> files = Driver.getDriver().findElements(By.xpath("(//tbody[@id='fileList'])[1]//tr"));
        //tbody//tr[@data-type='dir']
        List<Long> modifiedDateActual = new ArrayList<>();
       /* List<Integer> x =  new ArrayList<Integer>();
        int[] n = (int[])x.toArray(int[x.size()]);*/

        for (WebElement each : files) {

            modifiedDateActual.add(Long.valueOf(each.getAttribute("data-mtime")));

        }
        System.out.println("modifiedDateActual = " + modifiedDateActual);

        String expectedOrderByAscending="sort-indicator icon-triangle-n";
        String expectedOrderByDescending="sort-indicator icon-triangle-s";
        String actualOrder=folderViewPage.ModifiedDateSortIndicator.getAttribute("class");
        System.out.println("actualOrder = " + actualOrder);



        if (actualOrder.equals(expectedOrderByAscending)){
/* List<Integer> x =  new ArrayList<Integer>();
        int[] n = (int[])x.toArray(int[x.size()]);
        Integer[] n = x.toArray(new Integer[0]);*/

            Long[] modified = modifiedDateActual.toArray(new Long[0]);
            Arrays.sort(modified);
            System.out.println("modified = " + Arrays.toString(modified));

            List<Long> sortedModifiedDate = Arrays.asList(modified);
            System.out.println("sortedModifiedDate = " + sortedModifiedDate);

            Assert.assertEquals(sortedModifiedDate,modifiedDateActual);


        } else if (actualOrder.equals(expectedOrderByDescending)) {

            Long[] modified = modifiedDateActual.toArray(new Long[0]);
            Arrays.sort(modified);
            System.out.println("sizes = " + Arrays.toString(modified));

            List<Long> sortedModified = Arrays.asList(modified);
            System.out.println("sortedModified = " + sortedModified);

            Collections.reverse(sortedModified);
            Long[] descend = sortedModified.toArray(new Long[0]);
            System.out.println("descend = " + Arrays.toString(descend));

            List<Long> descendSizes = Arrays.asList(descend);

            Assert.assertEquals(descendSizes,modifiedDateActual);

        }
    }


}













