# Android RecyclerView UI Testing

Testing a RecyclerView is a bit different from a list View and below is an example of each implementation.

## Interacting with a ListView
ListView is an AdapterView. AdapterViews present a problem when doing UI testing. Since an AdapterView doesn't load all of it's items upfront (only as the user scrolls through the items), AdapterView's don't work well with onView(...) since the particular view might not be part of the view hierarchy yet.

Fortunately, Espresso provides an onData(...) entry point that makes sure to load the AdapterView item before performing any operations on it.

Let's run through an example of how you might interact with a ListView in Espresso. Our ListView will be a simple list of text strings.

> @Test  
public void clickOnItemWithTextEqualToTwo() {  
    >> // Find the adapter position to click based on matching the text "two" to the adapter item's text  
    onData(allOf(is(instanceOf(String.class)), is("two"))) // Use Hamcrest matchers to match item
        .inAdapterView(withId(R.id.lvItems)) // Specify the explicit id of the ListView  
        .perform(click()); // Standard ViewAction  
}

Alternately, if we know the position of the particular item, we can directly specify the position instead of using a data Matcher to find it:

> @Test  
public void clickOnItemWithTextEqualToTwo() {  
    // Directly specify the position in the adapter to click on
    onData(anything()) // We are using the position so don't need to specify a data matcher  
        .inAdapterView(withId(R.id.lvItems)) // Specify the explicit id of the ListView  
        .atPosition(1) // Explicitly specify the adapter item to use  
        .perform(click()); // Standard ViewAction  
}

## Interacting with a RecyclerView

Unfortunately, RecyclerView is not an AdapterView so we can't use onData(...) for a RecyclerView, but Espresso does support RecyclerView in the android.support.test.espresso.contrib package.

Let's first pull the package into our app build.gradle:

> // build.gradle  
dependencies {  
    >> ...  
    >> androidTestCompile('com.android.support.test.espresso:espresso-contrib:2.2') {  
        >>> // Necessary to avoid version conflicts  
        exclude group: 'com.android.support', module: 'appcompat'  
        exclude group: 'com.android.support', module: 'support-v4'  
        exclude group: 'com.android.support', module: 'support-annotations'  
        exclude module: 'recyclerview-v7'  
    >}  
}

Now we can use [RecyclerViewActions](http://developer.android.com/reference/android/support/test/espresso/contrib/RecyclerViewActions.html) to interact with our RecyclerView:

> // Click on the RecyclerView item at position 2
onView(withId(R.id.rvItems)).perform(RecyclerViewActions.actionOnItemAtPosition(2, click()));

You can see all the supported RecyclerViewActions (including how to interact with views inside of the RecyclerView item) [here](http://developer.android.com/reference/android/support/test/espresso/contrib/RecyclerViewActions.html)