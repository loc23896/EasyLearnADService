//package com.easy.learn.ultils;
//
//
//import lombok.extern.slf4j.Slf4j;
//import net.sf.jasperreports.engine.*;
//import net.sf.jasperreports.engine.export.JRCsvExporter;
//import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
//import net.sf.jasperreports.export.*;
//import net.sf.jasperreports.view.JasperViewer;
//import org.apache.commons.lang3.StringUtils;
//
//import java.io.File;
//import java.util.Map;
//
///**
// * @author modani
// */
//@Slf4j
//public class JasperReportUtils {
//    private static final String CSV_DELIMETER = ";";
//
//    /**
//     * @param reportPath
//     * @param params
//     * @return
//     * @throws JRException
//     */
//    public static JasperPrint getJasperPrint(String reportPath, Map<String, Object> params) throws JRException {
//        File file = new File(reportPath);
//        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
//        return JasperFillManager.fillReport(jasperReport, params, new JREmptyDataSource());
//    }
//
//    /**
//     * @param params
//     * @param reportPath
//     * @param destFileName contain .pdf
//     * @throws JRException
//     */
//    public static void exportPdf(Map<String, Object> params, String reportPath, String destFileName) throws JRException {
//        JasperPrint jasperPrint = JasperReportUtils.getJasperPrint(reportPath, params);
//        JasperReportUtils.exportPdf(jasperPrint, destFileName, params);
//    }
//
//    /**
//     * @param params
//     * @param reportPath
//     * @param destFileName contain .xlsx
//     * @throws JRException
//     */
//    public static void exportExcel(Map<String, Object> params, String reportPath, String destFileName) throws JRException {
//        JasperPrint jasperPrint = JasperReportUtils.getJasperPrint(reportPath, params);
//        JasperReportUtils.exportExcelFile(jasperPrint, destFileName);
//    }
//
//    /**
//     * @param params
//     * @param reportPath
//     * @param destFileName contain .csv
//     * @param delimiter
//     * @throws JRException
//     */
//    public static void exportCSV(Map<String, Object> params, String reportPath, String destFileName, String delimiter) throws JRException {
//        JasperPrint jasperPrint = JasperReportUtils.getJasperPrint(reportPath, params);
//        JasperReportUtils.exportCSVFile(jasperPrint,destFileName, delimiter);
//    }
//
//    /**
//     * @param pathReport
//     * @param params
//     * @throws JRException
//     */
//    public static void viewReport(String pathReport, Map<String, Object> params) throws JRException {
//        JasperPrint jasperPrint = JasperReportUtils.getJasperPrint(pathReport, params);
//        //viewReport
//        viewReport(jasperPrint);
//    }
//
//    /**
//     * @param jasperPrint
//     */
//    public static void viewReport(JasperPrint jasperPrint) {
//        //view
//        JasperViewer.viewReport(jasperPrint);
//    }
//
///**
// * @param jasperPrint
// * @param destFileName contain .xlsx
// * @throws JRException
// */