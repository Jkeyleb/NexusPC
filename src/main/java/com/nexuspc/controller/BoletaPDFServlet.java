package com.nexuspc.controller;
import com.lowagie.text.Image;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;
import java.io.IOException;
import com.nexuspc.model.Venta;
import com.nexuspc.model.DetalleVenta;
import com.nexuspc.service.VentaService;
import com.lowagie.text.pdf.PdfPTable;
import java.util.List;
import java.time.format.DateTimeFormatter;

@WebServlet("/boleta-pdf")
public class BoletaPDFServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        int idVenta = Integer.parseInt(
                request.getParameter("id"));

        Venta venta =
                ventaService.buscarPorId(idVenta);

        List<DetalleVenta> detalles =
                ventaService.listarDetalles(idVenta);

        response.setContentType("application/pdf");

        response.setHeader(
                "Content-Disposition",
                "inline; filename=Boleta.pdf");

        try {

            Document documento = new Document();

            PdfWriter.getInstance(
                    documento,
                    response.getOutputStream());

            documento.open();
            String rutaLogo =
                    getServletContext().getRealPath("/assets/img/nexus.png");

            Image logo = Image.getInstance(rutaLogo);

            logo.scaleToFit(100, 100);

            logo.setAlignment(Element.ALIGN_CENTER);

            documento.add(logo);

            Font titulo =
                    new Font(
                            Font.HELVETICA,
                            20,
                            Font.BOLD);

            Paragraph p1 =
                    new Paragraph(
                            "NEXUS PC",
                            titulo);

            p1.setAlignment(
                    Element.ALIGN_CENTER);

            documento.add(p1);

            documento.add(new Paragraph(" "));

            Paragraph sistema =
                    new Paragraph(
                            "Sistema de Inventario y Ventas");

            sistema.setAlignment(Element.ALIGN_CENTER);

            documento.add(sistema);

            Paragraph empresa =
                    new Paragraph("NexusPC");

            empresa.setAlignment(Element.ALIGN_CENTER);

            documento.add(empresa);

            documento.add(new Paragraph(" "));

            documento.add(new Paragraph(" "));

            Font subtitulo =
                    new Font(
                            Font.HELVETICA,
                            16,
                            Font.BOLD);

            Paragraph p2 =
                    new Paragraph(
                            "BOLETA DE VENTA",
                            subtitulo);

            p2.setAlignment(
                    Element.ALIGN_CENTER);

            documento.add(p2);

            documento.add(new Paragraph(" "));

            DateTimeFormatter fechaFormato =
                    DateTimeFormatter.ofPattern("dd/MM/yyyy");

            DateTimeFormatter horaFormato =
                    DateTimeFormatter.ofPattern("HH:mm:ss");

            documento.add(new Paragraph(
                    "Fecha: " +
                            venta.getFecha().format(fechaFormato)));

            documento.add(new Paragraph(
                    "Hora: " +
                            venta.getFecha().format(horaFormato)));

            documento.add(new Paragraph(
                    "N° Boleta: " +
                            String.format("%06d", venta.getIdVenta())));

            documento.add(new Paragraph(
                    "Cliente: " +
                            venta.getCliente().getNombre()));

            documento.add(new Paragraph(
                    "Vendedor: " +
                            venta.getUsuario().getNombre()));

            documento.add(new Paragraph(" "));

            PdfPTable tabla =
                    new PdfPTable(4);

            tabla.setWidthPercentage(100);

            tabla.addCell("Producto");
            tabla.addCell("Cantidad");
            tabla.addCell("Precio");
            tabla.addCell("Subtotal");

            double subtotal = 0;

            for(DetalleVenta d : detalles){

                tabla.addCell(
                        d.getProducto().getNombre());

                tabla.addCell(
                        String.valueOf(
                                d.getCantidad()));

                tabla.addCell(
                        String.format(
                                "S/ %.2f",
                                d.getPrecioUnitario()));

                tabla.addCell(
                        String.format(
                                "S/ %.2f",
                                d.getSubtotal()));

                subtotal += d.getSubtotal();

            }

            documento.add(tabla);

            double igv = subtotal * 0.18;

            double total = subtotal + igv;

            documento.add(new Paragraph(" "));

            documento.add(new Paragraph(
                    "Subtotal: S/ " +
                            String.format("%.2f", subtotal)));

            documento.add(new Paragraph(
                    "IGV (18%): S/ " +
                            String.format("%.2f", igv)));

            documento.add(new Paragraph(
                    "TOTAL: S/ " +
                            String.format("%.2f", total)));

            documento.add(new Paragraph(" "));

            Paragraph gracias =
                    new Paragraph(
                            "¡Gracias por su compra!");

            gracias.setAlignment(
                    Element.ALIGN_CENTER);

            documento.add(gracias);

            Paragraph pie =
                    new Paragraph(
                            "NexusPC");

            pie.setAlignment(
                    Element.ALIGN_CENTER);

            documento.add(pie);

            documento.close();

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

    private final VentaService ventaService =
            new VentaService();
}