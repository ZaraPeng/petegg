package com.petegg.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import org.supercsv.io.CsvBeanReader;
import org.supercsv.io.ICsvBeanReader;
import org.supercsv.prefs.CsvPreference;

/**
 * <p>
 * Title: CSVUtils
 * </p>
 * <p>
 * Description: com.petegg.util
 * </p>
 * <p>
 * Copyright: Copyright (c) 2015
 * </p>
 * <p>
 * Company: 客如云
 * </p>
 * 
 * @author Peng Yanan
 * @date 2016年8月28日
 */
public class CSVUtils {


  public void readCSV() throws IOException {
    InputStreamReader freader =
        new InputStreamReader(new FileInputStream(new File("csv/test1.csv")), "GB2312");

    ICsvBeanReader reader = new CsvBeanReader(freader, CsvPreference.EXCEL_PREFERENCE);

    // 获取头部信息
    String[] headers = reader.getHeader(true);
  }
}
