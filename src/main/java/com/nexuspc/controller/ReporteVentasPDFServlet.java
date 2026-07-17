package com.nexuspc.controller;

import com.nexuspc.service.VentaService;
import com.lowagie.text.*;
import com.lowagie.text.pdf.*;

import com.nexuspc.model.Venta;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;

@WebServlet("/reporte-ventas-pdf")
public class ReporteVentasPDFServlet extends HttpServlet {

    private final VentaService ventaService =
            new VentaService();

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws IOException {

        String desde =
                request.getParameter("desde");

        String hasta =
                request.getParameter("hasta");

        response.setContentType("application/pdf");

        response.setHeader(
                "Content-Disposition",
                "inline; filename=ReporteVentas.pdf");

        try {

            List<Venta> ventas;

            if (desde != null &&
                    !desde.isEmpty() &&
                    hasta != null &&
                    !hasta.isEmpty()) {

                ventas =
                        ventaService.listarPorFechas(
                                desde,
                                hasta);

            } else {

                ventas =
                        ventaService.listar();

            }

            Document documento =
                    new Document();

            PdfWriter.getInstance(
                    documento,
                    response.getOutputStream());

            documento.open();

            Font titulo =
                    new Font(
                            Font.HELVETICA,
                            20,
                            Font.BOLD);

            Paragraph p =
                    new Paragraph(
                            "NEXUS PC\n\nREPORTE DE VENTAS",
                            titulo);

            p.setAlignment(
                    Element.ALIGN_CENTER);

            documento.add(p);

            documento.add(new Paragraph(" "));

            documento.add(new Paragraph(
                    "Desde: " +
                            (desde == null ? "-" : desde)));

            documento.add(new Paragraph(
                    "Hasta: " +
                            (hasta == null ? "-" : hasta)));

            documento.add(new Paragraph(" "));

            PdfPTable tabla =
                    new PdfPTable(5);

            tabla.setWidthPercentage(100);

            tabla.addCell("ID");
            tabla.addCell("Fecha");
            tabla.addCell("Cliente");
            tabla.addCell("Vendedor");
            tabla.addCell("Total");

            DateTimeFormatter formato =
                    DateTimeFormatter.ofPattern(
                            "dd/MM/yyyy HH:mm");

            double total = 0;

            for(Venta v : ventas){

                tabla.addCell(
                        String.valueOf(
                                v.getIdVenta()));

                tabla.addCell(
                        v.getFecha()
                                .format(formato));

                tabla.addCell(
                        v.getCliente()
                                .getNombre());

                tabla.addCell(
                        v.getUsuario()
                                .getNombre());

                tabla.addCell(
                        String.format(
                                "S/ %.2f",
                                v.getTotal()));

                total += v.getTotal();

            }

            documento.add(tabla);

            documento.add(new Paragraph(" "));

            Font totalFont =
                    new Font(
                            Font.HELVETICA,
                            14,
                            Font.BOLD);

            Paragraph totalP =
                    new Paragraph(
                            "TOTAL VENDIDO: S/ "
                                    + String.format("%.2f", total),
                            totalFont);

            totalP.setAlignment(
                    Element.ALIGN_RIGHT);

            documento.add(totalP);

            documento.add(new Paragraph(" "));

            documento.add(new Paragraph(
                    "Fecha de emisión: "
                            + LocalDate.now()));

            documento.add(new Paragraph(
                    "Sistema NexusPC"));
            documento.close();

        }catch(Exception e){

            e.printStackTrace();

        }

    }
}