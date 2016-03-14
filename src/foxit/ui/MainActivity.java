package foxit.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.view.Display;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnKeyListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.foxit.gsdk.PDFException;
import com.foxit.gsdk.PDFLibrary;
import com.foxit.gsdk.pdf.PDFDocument;
import com.foxit.gsdk.pdf.annots.Annot;
import com.ionicframework.sideionic304115.R;

import java.io.File;

import foxit.bean.AnnotInfo;
import foxit.bean.PDFContext;
import foxit.controller.ViewController;
import foxit.popupmenu.MenuItem;
import foxit.popupmenu.PopupMenu;
import foxit.view.PDFPagerAdapter;
import foxit.view.PDFView;
import foxit.view.PDFViewPager;

public class MainActivity extends Activity
{
	private static final String TAG = "MainActivity";

	private PDFLibrary pdfLibrary = null;
	private ViewController viewController = null;

	private static String license_id = "N8A6/QKgxqUZNTwPMt6snCcJl+mShO9AMqyLeO5e2BVgUtHiL+q06g==";
	private static String unlockCode = "8f3o10dtvRkNRDfKrVJC+0frhjHtvOcfhpLWVbqaEks4r+x35JFzFBVmg3pedmy5vRH/m9t3Eiw3qFFYENo8xe3iGAE9Txe6Z/Lo6dahPRI9OhjH/68P8IFmFccnjfcLkOs2vInl2i3t5XO70UAYxOVG26s8KA5KuUyOKYkPg7O//3C6lGQ2MFy6Fk4JL+t7lsft7j68068uqUgjQLQ6/UQ7JhnnzjWMuPIdvs3mKv4Oq3fszVLHVjRLrbppcFlrA4ZBoPARAp796iyIeOtoYHlE/EVOVQR/LEHLTBaPSY1gV1+r0wbkFksxAqn8NHKdd4nYavtqFr3Sm99EMPJNp0fd06NbFC6kkfrMjo44kCtZkG//GMJw5x/Ujx/jYOY58rXTHo3JssySM1dvaBqOG2DFSXzRZJDtV4UoansvdHoJuUs6K8th7z2cHpApP4qBeM3Q/Yp/tA7gwHDG5mVQ/MScfX+6v8GGfdJLiLP+7zLVj30aBxr4V9iQy2jWlGEszQmDBRdXTSPbZAxw0hRG5n+ceKXVS1n1drBosoejWhL5q8Sey/62J1uHqq9n14Agr8qPiKOCQmH43ZFosL8t79ip22+6HffUNdGTLMbW7Mw1nRLh6b49oYqKMqFUp0RLnVLIROG0XunFPTNd4sExJJyVbWbyI/UEXAMPyw+qZCAaqxu2cwpYVAsj7ndL9bYE/QtWd67julWdWe2r3rBpTaHu9HTq+3H1GJG6SFaIMKpkEJrCxRNHc2WmzOIzAd9/u25EvQUZiB91xDDTVVkwcZ0SjflFDd1EVMZcGq32braan6qZjTmflGV9LjTFR+dLy5nTXSaxxdoOYR6223QiraF2VPZlr8ErnoV8N7iZu6DHqf8urJ7JFxpYZ/7SQqOploa3DetwAz6b1XGNZljgYDZBb4O0YHDtUOkjcz8wW6mJGmOKiEJg093elJOaltlZo0zf8RLU0yoeV7bYfvxcNMWobVPQMPtQA2iqZXz9dENHSRS7s0oc8IIFZUCSCKucNNN5XLxECe3HZv7WRxL8E8bUvLYRuQFKmg5dVcilhhJpodSjOq/YZk+j2Dky7nBnBRt2QH/BD26oAyxpIQpEdc820jyYXugtT2rVvAE03vHcEoqsYjK+URQlwb1SSNwDOQEC/qvFPPMlImO8UfTiWAVU1P9XRAUVvmQcJ8NRQETaNar6j62MMB6nDE9akobUuImlQ2Tf4uKSW1kodWE8N6sJqlGyOxYkOF/4Ls1tr5Lr+NEjXNlvbVWm3cjQeDowCTAzpCL3JSBJwfywJDnFmUodqL7JW2DSp6dv2TFZGQDIPXB9SOLojb7LfJ3hw1ClYYLrTgyeLIhgrBmOehf8T6VyZximltSuaY3H5lnlJp2rj+QfHfYizCyNEvip+qztGX7cZwWjFYhHfiDcizU5KPUwZ+/BFN/50QOZqF7ZByi15h6032TY7NWzxE50CV5atdk8DZi2tQ9UWG07N16aQSbqC8l8dHIEm/voLqowB+V0quL0oUY1voKOV56Wt1Xm8bNqJ/SJRgLhKmEnxcpEyZJKFIWD0T5tiC2sYNk8jVr6sSQlFrael2wEkggqEFkqE+frLnZXa1njIdjvsCQJ5VObzY94k9b4Ffnxl5m4fy65r3IraDhEjLqvqHaGajPlTgJpJYHJg6fBUOhdknjQu+DPBYQTh4hdSsmyFcgrBQHZaCr1E2ukWawc0Y2R7j1cAJRVAwRdzQ8IFU8BbMF8MqlzDMBt9MQlgTPHC1javGT5aIGh";
	private int memorySize = 12 * 1024 * 1024;
	private boolean scaleable = true;
	//variables for layout
	private RelativeLayout layout = null;
	private View topBarView = null;
	private View bottomBarView = null;
	private View search_topBarView = null;
	private View search_bottomBarView = null;
	private EditText searchEditText = null;
	private String searchText = null;
	private static boolean isSeacrhing = false;
	private static String lastFileName = null;  //whether is the same file
	private boolean bOpenSuccess = true;
	private TextView pageindexView = null;
	private PDFContext pdfContext = null;

	private static final int MODEL_IMPORT = 1;
	private static final int MODEL_EXPORT = 2;
	private int operationMode = 0;//import or export

	private boolean bPressSave = false;

	//load foxit pdf library
	static{
//		System.loadLibrary("fsdk_android");
	}

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);

		//initialize PDF library for using Foixt APIs
		pdfLibrary = PDFLibrary.getInstance();
		try
		{
			pdfLibrary.initialize(memorySize, scaleable);
			pdfLibrary.unlock(license_id, unlockCode);
		}
		catch (PDFException e)
		{
			e.printStackTrace();
			Toast.makeText(MainActivity.this, "Fail to unlock PDF library", Toast.LENGTH_SHORT).show();
			this.finish();
			return;
		}

		viewController = ViewController.create(this);

		String filePath = getFilePath();
		if (lastFileName == null)
		{
			lastFileName = filePath;
		}
		else
		{
			if (!lastFileName.equals(filePath))
			{
				isSeacrhing = false;
				lastFileName = filePath;
			}
		}
		try
		{
			viewController.openDocument(filePath, null);
		}
		catch (PDFException e)
		{
			if (e.getLastError() == PDFException.ERRCODE_PASSWORD)
			{
				PasswordDialog passwordDialog = new PasswordDialog(this, viewController, filePath, R.style.PasswordDialog);
				passwordDialog.setCanceledOnTouchOutside(false);
				passwordDialog.showDialog();
			}
			else {
				Toast.makeText(MainActivity.this, "Fail to open document.", Toast.LENGTH_SHORT).show();
				bOpenSuccess = false;
				this.finish();
				return;
			}

		}
		if(bOpenSuccess)
		{
			viewController.initialize();
			viewController.setParent(this);
			pdfContext = viewController.getTaskManager().getPDFContext();

			getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
					WindowManager.LayoutParams.FLAG_FULLSCREEN);
			requestWindowFeature(Window.FEATURE_NO_TITLE);

			//show view
			layout = new RelativeLayout(this);
			if (!isSeacrhing)
			{
				setLayout(layout);
			}
			else {
				resetLayoutOnSearch(layout);
			}
		}
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu){
		menu.clear();
		if(pdfContext.isSupportPSI() == true)
			getMenuInflater().inflate(R.menu.psi_menu, menu);
		else {
			getMenuInflater().inflate(R.menu.main, menu);
		}
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(android.view.MenuItem item)
	{
		if (item.getItemId() == R.id.save)
		{
			//save the current document
			if (viewController != null && lastFileName != null)
			{
				String fileName = lastFileName + ".tmp";
				viewController.saveDocument(fileName, PDFDocument.SAVEFLAG_OBJECTSTREAM);
				bPressSave = true;
			}
		}
		//cancel PSI operation
		if(item.getItemId() == R.id.cancel){
			pdfContext.setPSIFlag(false);
			viewController.cancelPsi();
			resetLayoutAfterPsi(layout);
		}
		//comfirm PSI operation
		if(item.getItemId() == R.id.confirm){
			pdfContext.setPSIFlag(false);
			viewController.confirmPsi();
			resetLayoutAfterPsi(layout);
		}

		return true;
	}

	@Override
	protected void onDestroy()
	{
		super.onDestroy();
		this.getWindow().clearFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		if(viewController!=null)
		{
			viewController.destroy();
			viewController.closePage();
			viewController.closeDocument();
		}
		viewController = null;
		if(pdfLibrary!=null)
			pdfLibrary.destroy();
		pdfLibrary = null;
		viewController = null;
	}

	private String getFilePath()
	{
		Intent intent = getIntent();
		String filePath = intent.getStringExtra("fileDir");

		if(filePath == null || filePath.length() == 0)
		{
			Uri uri = intent.getData();
			filePath = uri.getPath();
		}

		return filePath;
	}

	//set and show view
	private void setLayout(RelativeLayout layout)
	{

		layout.addView(viewController.getViewPager());//viewpager

		//top bar
		topBarView = View.inflate(this, R.layout.top_bar, null);

		layout.addView(topBarView);

		//bottom bar
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

		bottomBarView = View.inflate(this, R.layout.bottom_bar, null);
		layout.addView(bottomBarView, layoutParams);

		layout.addView(View.inflate(this, R.layout.pageindex, null));

		setContentView(layout);

		//show pageindex
		pageindexView = (TextView) findViewById(R.id.textView1);
		pageindexView.setText((pdfContext.pageIndex + 1) + "/" + pdfContext.pageCount);
		//monitor Bar
		monitorBar(toolbarListener);
	}

	private void monitorBar(OnCheckedChangeListener listener)
	{
		//Monitor top bar
		RadioGroup topBarGroup = (RadioGroup) findViewById(R.id.toolbar_top);
		topBarGroup.setOnCheckedChangeListener(listener);

		//Monitor bottom bar
		RadioGroup bottomBarGroup = (RadioGroup) findViewById(R.id.toolbar_bottom);
		bottomBarGroup.getBackground().setAlpha(128);
		bottomBarGroup.setOnCheckedChangeListener(listener);
	}

	//reset layout
	private void resetLayoutOnSearch(RelativeLayout layout)
	{
		if (isSeacrhing)
		{
			layout.addView(viewController.getViewPager());
		}
		else {//remove top&bottom bar first
			layout.removeViewInLayout(topBarView);
			layout.removeViewInLayout(bottomBarView);
		}

		//add search_top&bottom bar to the layout
		search_topBarView = View.inflate(MainActivity.this, R.layout.search_top_bar, null);
		layout.addView(search_topBarView);

		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
		search_bottomBarView = View.inflate(MainActivity.this, R.layout.search_bottom_bar, null);
		layout.addView(search_bottomBarView, layoutParams);

		if (isSeacrhing)
		{
			layout.addView(View.inflate(this, R.layout.pageindex, null));
			setContentView(layout);
			//show pageindex
			pageindexView = (TextView) findViewById(R.id.textView1);
			pageindexView.setText((pdfContext.pageIndex + 1) + "/" + pdfContext.pageCount);
		}

		//monitor search bar
		monitorSearchBar(toolbarListener);

		searchEditText = (EditText) findViewById(R.id.searchText);
		searchEditText.setOnKeyListener(keyListener);

		isSeacrhing = true;
	}

	private void resetLayoutAfterSearch(RelativeLayout layout)
	{
		//remove search top&bottom bar first
		layout.removeViewInLayout(search_topBarView);
		layout.removeViewInLayout(search_bottomBarView);

		//add top&bottom bar to the layout
		//top bar
		topBarView = View.inflate(this, R.layout.top_bar, null);
		layout.addView(topBarView);

		//bottom bar
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

		bottomBarView = View.inflate(this, R.layout.bottom_bar, null);
		layout.addView(bottomBarView, layoutParams);

		//monitor Bar
		monitorBar(toolbarListener);

		isSeacrhing = false;
	}

	private void resetLayoutOnPsi(RelativeLayout layout){

		layout.removeViewInLayout(topBarView);
		layout.removeViewInLayout(bottomBarView);
		setContentView(layout);

	}

	private void resetLayoutAfterPsi(RelativeLayout layout){
		//top bar
		topBarView = View.inflate(this, R.layout.top_bar, null);

		layout.addView(topBarView);

		//bottom bar
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT,
                LayoutParams.WRAP_CONTENT);
		layoutParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

		bottomBarView = View.inflate(this, R.layout.bottom_bar, null);
		layout.addView(bottomBarView, layoutParams);

		//monitor Bar
		monitorBar(toolbarListener);
	}
	private void monitorSearchBar(OnCheckedChangeListener listener)
	{
		RadioGroup bottomBarGroup = (RadioGroup) findViewById(R.id.search_toolbar_bottom);
		if (bottomBarGroup == null) return;
		bottomBarGroup.getBackground().setAlpha(128);
		bottomBarGroup.setOnCheckedChangeListener(listener);
	}

	OnCheckedChangeListener toolbarListener = new OnCheckedChangeListener()
	{

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId)
		{
			if(viewController == null)
				return;
			RadioButton radioButton = (RadioButton) MainActivity.this.findViewById(checkedId);
			switch (checkedId)
			{
			case R.id.radio_prevPage:
				viewController.turnpage(false);
				break;
			case R.id.radio_search:
				resetLayoutOnSearch(layout);
				break;
			case R.id.radio_nextPage:
				viewController.turnpage(true);
				break;
			case R.id.radio_zoomIn:
				viewController.zoom(true);
				break;
			case R.id.radio_zoomOut:
				viewController.zoom(false);
				break;
			case R.id.radio_searchPrev:
				viewController.searchPrev();
				break;
			case R.id.radio_searchNext:
				viewController.searchNext();
				break;
			case R.id.radio_annot:
			{
				WindowManager wm = (WindowManager)MainActivity.this.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
				Display display = wm.getDefaultDisplay();
				PopupMenu menu = new PopupMenu(MainActivity.this, display.getWidth() / 4, LayoutParams.WRAP_CONTENT);
				menu.addMenuItem(new MenuItem("Highlight"));
				menu.addMenuItem(new MenuItem("Underline"));
				menu.addMenuItem(new MenuItem("Link"));
				menu.addMenuItem(new MenuItem("FreeText"));
				menu.addMenuItem(new MenuItem("Note"));
				menu.addMenuItem(new MenuItem("PSI"));
				menu.addMenuItem(new MenuItem("Import"));
				menu.addMenuItem(new MenuItem("Export"));
				menu.inflateMenuItems();
				menu.show(radioButton, true);
				menu.setItemOnClickListener(annotItemOnClickListener);
			}
				break;
			case R.id.radio_rotate:
			{
				WindowManager wm = (WindowManager)MainActivity.this.getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
				Display display = wm.getDefaultDisplay();
				PopupMenu menu = new PopupMenu(MainActivity.this, display.getWidth() / 4, LayoutParams.WRAP_CONTENT);
				menu.addMenuItem(new MenuItem("Rotate Left"));
				menu.addMenuItem(new MenuItem("Rotate Right"));
				menu.inflateMenuItems();
				menu.show(radioButton, false);
				menu.setItemOnClickListener(rotationItemOnClickListener);
			}
				break;
			default:
				break;
			}
			radioButton.setChecked(false);
			//update pageindex
			if(pageindexView != null)
			    pageindexView.setText((pdfContext.pageIndex + 1) + "/" + pdfContext.pageCount);
		}
	};

	public void onBack(View view)
	{
		resetLayoutAfterSearch(layout);
		//reset searchText
		searchText = null;
		clearHighlightText();
	}

	OnKeyListener keyListener = new OnKeyListener()
	{
		@Override
		public boolean onKey(View v, int keyCode, KeyEvent event)
		{
			if (KeyEvent.KEYCODE_ENTER == keyCode
			        && event.getAction() == KeyEvent.ACTION_DOWN)
			{
				InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
				imm.hideSoftInputFromWindow(searchEditText.getWindowToken(), 0);

				clearHighlightText();
				searchText = searchEditText.getText().toString();
				if(!searchText.equals(""))
					viewController.startSearch(MainActivity.this, searchText);
				else
					Toast.makeText(MainActivity.this, "Please input search text!", Toast.LENGTH_SHORT).show();
				return true;
			}
			return false;
		}
	};

	@Override
	public void onConfigurationChanged(Configuration newConfig)
	{
		super.onConfigurationChanged(newConfig);
		if( viewController== null)
			return;
		if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
		    viewController.resetConfiguration();
		}
		else if (this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
			viewController.resetConfiguration();
		}
	}

	private void clearHighlightText()
	{
		if(viewController == null)
			return;
		PDFViewPager pdfViewPager = (PDFViewPager)viewController.getViewPager();
		PDFPagerAdapter pdfPagerAdapter = (PDFPagerAdapter)pdfViewPager.getAdapter();
		int index = viewController.getTaskManager().getPDFContext().pageIndex;
		PDFView pdfView = pdfPagerAdapter.getViewMap().get(index);
		if (pdfView == null)
			return;
		else
		{
			pdfView.clearHighlight();
			pdfView.postInvalidate();
		}
		viewController.destroy();
	}

	PopupMenu.OnItemOnClickListener annotItemOnClickListener = new PopupMenu.OnItemOnClickListener()
	{

		@Override
		public void onItemClick(MenuItem item, int position)
		{
			String type = null;
			if(pdfContext.getCurrentState().bAnnotLicense == false)
			{
				//Toast or dialog
				Toast.makeText(MainActivity.this, "no annot license!!!", Toast.LENGTH_SHORT).show();
				return;
			}
			switch (position)
			{
			case 0:
				type = Annot.TYPE_HIGHLIGHT;
				break;
			case 1:
				type = Annot.TYPE_UNDERLINE;
				break;
			case 2:
				type = Annot.TYPE_LINK;
				break;
			case 3:
				type = Annot.TYPE_FREETEXT;
				break;
			case 4:
				type = Annot.TYPE_TEXT;
				break;
			case 5:
				{	//click to start PSI operation
					if(pdfContext.getCurrentState().rotation == 0){
						if (viewController != null) {
							resetLayoutOnPsi(layout);
							viewController.initPsi();
							pdfContext.setPSIFlag(true);
						}
					}
				}
				break;
			case 6:
				{
					Intent intent = new Intent();
					intent.setClass(MainActivity.this, FileSelectorActivity.class);
					startActivityForResult(intent, 1);//requestCode = 1
					operationMode = MODEL_IMPORT;
				}
				break;
			case 7:
				{
					Intent intent = new Intent();
					intent.setClass(MainActivity.this, FileSelectorActivity.class);
					startActivityForResult(intent, 1);//requestCode = 1
					operationMode = MODEL_EXPORT;
				}
				break;

			default:
				break;
			}

			if (type != null)
			{
				AnnotInfo annotInfo = new AnnotInfo(type, AnnotInfo.TYPE_ADD);
				//use in ViewContoller
				if(viewController != null)
					viewController.setAnnotInfo(annotInfo);
			}
		}
	};

	PopupMenu.OnItemOnClickListener rotationItemOnClickListener = new PopupMenu.OnItemOnClickListener()
	{

		@Override
		public void onItemClick(MenuItem item, int position)
		{
			int direction = -1;
			switch (position)
			{
			case 0:
				direction = ViewController.ROTATIONDIRECTION_LEFT;
				break;
			case 1:
				direction = ViewController.ROTATIONDIRECTION_RIGHT;
				break;
			default:
				break;
			}
			if(viewController != null)
				viewController.onRotation(direction);
		}
	};

	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data)
	{

		if(viewController == null)
			return;
		if (requestCode == 1 && resultCode == 2)
		{
			Bundle bundle = data.getBundleExtra("Result");
			String filePath = bundle.getString("file");

			if (operationMode == MODEL_IMPORT)
			{
				//import annot from fdf
				viewController.importAnnotsFromFDF(filePath);
			}
			else if (operationMode == MODEL_EXPORT)
			{
				//export annot to fdf
				viewController.exportAnnotsToFDF(lastFileName, filePath);
			}
			operationMode = 0;
		}
		super.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event)
	{
		if ((keyCode == KeyEvent.KEYCODE_BACK && viewController != null))
		{
			viewController.destroy();
			viewController.closePage();
			viewController.closeDocument();
			//release psi
			if (pdfContext.isSupportPSI() == true)
			{
				viewController.releasePsi();
				pdfContext.setPSIFlag(false);
			}

			if (bPressSave)
			{
				File file = new File(lastFileName);
				if (file != null)
					file.delete();
				File newfile = new File(lastFileName + ".tmp");
				if (newfile != null)
					newfile.renameTo(file);

				bPressSave = false;
			}

		}
		return super.onKeyDown(keyCode, event);
	}



}
