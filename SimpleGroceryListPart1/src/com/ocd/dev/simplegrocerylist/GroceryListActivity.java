package com.ocd.dev.simplegrocerylist;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.glass.widget.CardScrollAdapter;
import com.google.android.glass.widget.CardScrollView;

public class GroceryListActivity extends Activity {
	private CardScrollView mCardScrollView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		mCardScrollView = new CardScrollView(this);
		
		// get a list of groceries from somewhere, perhaps a web service or a file
		// will hardcode values for this sample
		GroceryItemCards groceryItemCards = new GroceryItemCards(this);
		groceryItemCards.addGroceryItem(
				new GroceryItem("Black rasberry chip ice cream",
						R.drawable.icecream));
		groceryItemCards.addGroceryItem(new GroceryItem("potatoes"));
		groceryItemCards.addGroceryItem(new GroceryItem("chicken"));
		groceryItemCards.addGroceryItem(new GroceryItem("rice", R.drawable.rice));
		
		CardScrollAdapter adapter = new ListCardScrollAdapter(groceryItemCards.getCards());
		mCardScrollView.setAdapter(adapter);
		mCardScrollView.activate(); // important. do not forget.
		
		setContentView(mCardScrollView);
	}
}
