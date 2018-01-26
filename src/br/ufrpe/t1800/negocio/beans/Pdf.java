package br.ufrpe.t1800.negocio.beans; 
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
public class Pdf {
	
	public static void Gerador(Receita r) {
		Document document = new Document();
		
		try {
			PdfWriter.getInstance(document, new FileOutputStream("receita.pdf"));
			document.open();
			document.add(new Paragraph(r.toString() + "\n\n\n"));
		} catch(DocumentException e){
			System.out.println(e.getMessage());
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			document.close();
		}
		
		
		try{
			Desktop.getDesktop().open(new File("receita.pdf"));
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
}
