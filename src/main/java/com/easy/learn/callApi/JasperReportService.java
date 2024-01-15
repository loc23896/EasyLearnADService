package com.easy.learn.callApi;

import com.easy.learn.dto.TrainerSalaryPaid.TrainerSalaryPaid;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class JasperReportService {

    public byte[] generateTrainerSalaryPaidReport(List<TrainerSalaryPaid> trainerSalaries) throws JRException {
        JasperReport jasperReport = JasperCompileManager.compileReport("src/main/resources/reports/Simple_Blue.jrxml");
        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(trainerSalaries);
        Map<String, Object> parameters = new HashMap<>();
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
        return JasperExportManager.exportReportToPdf(jasperPrint);
    }
}