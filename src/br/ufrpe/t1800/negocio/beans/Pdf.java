package br.ufrpe.t1800.negocio.beans; 
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import br.ufrpe.t1800.gui.login.LoginPessoa;
public class Pdf {
	
	public static void geradorReceita(ArrayList<Receita> r) {
		Document document = new Document();
		
		try {
			PdfWriter.getInstance(document, new FileOutputStream("receita.pdf"));
			document.open();
			Image img = Image.getInstance(LoginPessoa.class.getResource("iconePdf.png"));
			img.setAlignment(Element.ALIGN_CENTER);
			document.add(img);
		
			
			Paragraph p = new Paragraph("RELATÓRIO GERAL DE RECEITAS", new Font(FontFamily.TIMES_ROMAN, 22));
			p.setAlignment(Element.ALIGN_CENTER);
			document.add(p);
			document.add(new Paragraph("\n\n\n"));
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
	
	public static void geradorDespesaCartao(ArrayList<DespesaCartao> d) {
		Document documento = new Document();
		
		try {
			PdfWriter.getInstance(documento, new FileOutputStream("DespesaCartao.pdf"));
			documento.open();
			Image img = Image.getInstance(LoginPessoa.class.getResource("iconePdf.png"));
			img.setAlignment(Element.ALIGN_CENTER);
			documento.add(img);
		
			Paragraph p = new Paragraph("RELATÓRIO GERAL DE DESPESAS", new Font(FontFamily.TIMES_ROMAN, 22));
			p.setAlignment(Element.ALIGN_CENTER);
			documento.add(p);
			documento.add(new Paragraph("\n\n\n"));
			documento.add(new Paragraph(d.toString() + "\n\n\n"));
		} catch(DocumentException e){
			System.out.println(e.getMessage());
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			documento.close();
		}
		
		
		try{
			Desktop.getDesktop().open(new File("DespesaCartao.pdf"));
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
	
	public static void geradorDespesaComum(ArrayList<DespesaComum> despesa) {
		Document documento1 = new Document();
		
		try {
			PdfWriter.getInstance(documento1, new FileOutputStream("DespesaComum.pdf"));
			documento1.open();
			Image img = Image.getInstance(LoginPessoa.class.getResource("iconePdf.png"));
			img.setAlignment(Element.ALIGN_CENTER);
			documento1.add(img);
		
			
			Paragraph p = new Paragraph("RELATÓRIO GERAL DE DESPESAS", new Font(FontFamily.TIMES_ROMAN, 22));
			p.setAlignment(Element.ALIGN_CENTER);
			documento1.add(p);
			documento1.add(new Paragraph("\n\n\n"));
			documento1.add(new Paragraph(despesa.toString() + "\n\n\n"));
		} catch(DocumentException e){
			System.out.println(e.getMessage());
		}  catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			documento1.close();
		}
		
		try{
			Desktop.getDesktop().open(new File("DespesaComum.pdf"));
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}
}
