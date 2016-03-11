package foxit.task;

import android.util.Log;

import com.foxit.gsdk.PDFException;
import com.foxit.gsdk.pdf.PDFDocument;

import foxit.bean.PDFContext;

public class LoadDocumentTask extends AbstractTask
{
	public static final String TAG = "LoadDocumentTask";

	private PDFContext pdfContext = null;
	private PDFDocument document = null;
	private int pageCount = 0;

	public LoadDocumentTask(PDFContext pdfContext)
	{
		this.pdfContext = pdfContext;
		this.document = pdfContext.getDocument();
		this.taskType = TYPE_LOADDOCUMENT;
	}

	@Override
	public boolean execute()
	{
		if (document != null)
		{
			try
			{
				pageCount = document.countPages();
			}
			catch (PDFException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();

				Log.i(TAG, "Failed to count pages, error code = " + e.getLastError());
				return false;
			}
			pdfContext.pageCount = pageCount;
			return true;
		}

		Log.i(TAG, "Please load PDF document");
		return false;
	}

}
