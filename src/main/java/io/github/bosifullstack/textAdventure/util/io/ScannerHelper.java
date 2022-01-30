package io.github.bosifullstack.textAdventure.util.io;

import java.util.Scanner;

/*Singleton class to fetch Scanner
*
* NOTE: needed for Scanner limitations*/
public class ScannerHelper {

    private static ScannerHelper _instance = null;
    private Scanner scanner;

    private ScannerHelper(){
        scanner = new Scanner(System.in);
    }

    public static ScannerHelper getInstance(){
        if(_instance == null){
            _instance = new ScannerHelper();
        }
        return _instance;
    }

    public Scanner getScanner() {
        return scanner;
    }

}
