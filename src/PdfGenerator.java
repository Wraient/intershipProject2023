import java.io.IOException;
import java.util.Arrays;
import java.util.List;
//import java.util.stream.IntStream;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

public class PdfGenerator {
    private static final String FILE_PATH = "D:\\a.pdf";
    private final PDDocument invoice;
    private final List<String> productNames;
    private final List<Integer> productPrices;
    private final List<Integer> productQuantities;
	private final String totalprice;
    
    private final String customerName;
    private final String customerPhone;
	private final String customerVehicle;
	private final String customerVehicleModel;

    private final String invoiceTitle = "           !! Mauli Auto Garage !!";
    private final String subTitle = "Invoice";



    public PdfGenerator(String customerName, String customerPhone, String customerVehicle, String customerVehicleModel, 
    		List<String> productNames, List<Integer> productPrices, List<Integer> productQuantities, String total) 
    	throws IOException {
        this.customerName = customerName;
        this.customerPhone = customerPhone;
        this.customerVehicle = customerVehicle;
        this.customerVehicleModel = customerVehicleModel;
        this.productNames = productNames;
        this.productPrices = productPrices;
        this.productQuantities = productQuantities;
        this.totalprice = total;

        invoice = new PDDocument();
        PDPage newPage = new PDPage();
        invoice.addPage(newPage);
    }

    public void generatePdf() throws IOException {
        PDPageContentStream cs = null; // Initialize outside the try block
        try {
            cs = new PDPageContentStream(invoice, invoice.getPage(0));

            cs.setFont(PDType1Font.TIMES_ROMAN, 20);
            cs.beginText();
            cs.newLineAtOffset(140, 750);
            cs.showText(invoiceTitle);
            cs.endText();

            cs.setFont(PDType1Font.TIMES_ROMAN, 18);
            cs.beginText();
            cs.newLineAtOffset(270, 690);
            cs.showText(subTitle);
            cs.endText();

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 14);
            cs.setLeading(20f);
            cs.newLineAtOffset(60, 610);
            cs.showText("Customer Name: ");
            cs.newLine();
            cs.showText("Phone Number: ");
            cs.newLine();
            cs.showText("Vehicle Number: ");
            cs.newLine();
            cs.showText("Model: ");
            cs.endText();
            
            cs.setFont(PDType1Font.TIMES_ROMAN, 14);
            cs.beginText();
            cs.newLineAtOffset(170, 610);
            cs.showText(customerName);
            cs.newLine();
            cs.showText(customerPhone);
            cs.newLine();
            cs.showText(customerVehicle);
            cs.newLine();
            cs.showText(customerVehicleModel);
            cs.endText();
           

            cs.setFont(PDType1Font.TIMES_ROMAN, 14);
            cs.beginText();
            cs.newLineAtOffset(80, 500);
            cs.showText("Particulars");
            cs.endText();

            cs.setFont(PDType1Font.TIMES_ROMAN, 14);
            cs.beginText();
            cs.newLineAtOffset(260, 500);
            cs.showText("Rate");
            cs.endText();

            cs.setFont(PDType1Font.TIMES_ROMAN, 14);
            cs.beginText();
            cs.newLineAtOffset(310, 500);
            cs.showText("Quantity");
            cs.endText();

            cs.setFont(PDType1Font.TIMES_ROMAN, 14);
            cs.beginText();
            cs.newLineAtOffset(410, 500);
            cs.showText("Amount");
            cs.endText();

            int yPosition = 480;
            for (int i = 0; i < productNames.size(); i++) {
                cs.setFont(PDType1Font.TIMES_ROMAN, 12);
                cs.beginText();
                cs.newLineAtOffset(80, yPosition);
                cs.showText(productNames.get(i));
                cs.endText();

                cs.setFont(PDType1Font.TIMES_ROMAN, 12);
                cs.beginText();
                cs.newLineAtOffset(260, yPosition);
                cs.showText(productPrices.get(i).toString());
                cs.endText();

                cs.setFont(PDType1Font.TIMES_ROMAN, 12);
                cs.beginText();
                cs.newLineAtOffset(310, yPosition);
                cs.showText(productQuantities.get(i).toString());
                cs.endText();

                int amount = productPrices.get(i) * productQuantities.get(i);
                cs.setFont(PDType1Font.TIMES_ROMAN, 12);
                cs.beginText();
                cs.newLineAtOffset(410, yPosition);
                cs.showText(Integer.toString(amount));
                cs.endText();

                yPosition -= 20;
            }

            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 14);
            cs.newLineAtOffset(350, 100);
            cs.showText("Total");
            cs.endText();
                        
            
            cs.beginText();
            cs.setFont(PDType1Font.TIMES_ROMAN, 14);
            cs.newLineAtOffset(410, 100);
            cs.showText(totalprice);
            cs.endText();
            
        } finally {
            if (cs != null) {
                cs.close(); // Close the PDPageContentStream
            }
        }

        invoice.save(FILE_PATH);
        invoice.close();
    }

    public static void main(String[] args) throws IOException {
        List<String> productNames = Arrays.asList("Kurkure", "Lays", "Doritos");
        List<Integer> productPrices = Arrays.asList(20, 25, 30);
        List<Integer> productQuantities = Arrays.asList(5, 3, 2);
        
        int pretotal = 0;
        for (int i = 0; i < productNames.size(); i++) {
            pretotal += productPrices.get(i) * productQuantities.get(i);
        }

        String total = String.valueOf(pretotal);
        PdfGenerator pdfGenerator = new PdfGenerator("Om Prakash Varma", "8978675645", "Toyota", "Innova", productNames, productPrices, productQuantities, total);
        pdfGenerator.generatePdf();
        System.out.println("Invoice generated successfully!");
    }
}
