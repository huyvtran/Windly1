package foxit.task;

import android.util.Log;

import com.foxit.gsdk.PDFException;

import foxit.bean.PDFContext;

public class CloseDocumentTask extends AbstractTask
{
	public static final String TAG = "CloseDocumentTask";

	private PDFContext pdfContext = null;

	public CloseDocumentTask(PDFContext pdfContext)
	{
		this.pdfContext = pdfContext;
		this.taskType = TYPE_CLOSEDOCUMENT;
	}

	@Override
	public boolean execute()
	{
		if (pdfContext != null && pdfContext.document != null)
		{
			try
			{
				pdfContext.document.close();
			}
			catch (PDFException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
				Log.i(TAG, "Failed to close document, error code = " + e.getLastError());
				return false;
			}
			pdfContext.document = null;
			return true;
		}
		Log.i(TAG, "Please load PDF document");
		return false;
	}

}
