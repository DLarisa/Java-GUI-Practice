package interfete;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Date;

public class AuditGUI implements Runnable {
	private static AuditGUI instance;

	public void run() {
		try {
            Files.write(Paths.get("auditGUI.csv"), (Thread.currentThread().getName() + "\n").getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
	
    public AuditGUI() {
    }

    public static AuditGUI getInstance() {
        if (instance == null) {
            instance = new AuditGUI();
        }
        return instance;
    }
    
    public static void scriereFisier(Thread t) {
    	System.out.println(Thread.currentThread().getName() + "\n");
    
    }

    public void scriereFisier(int optiuneAleasa) {
        String s = "";
        switch (optiuneAleasa) {
        	case 0: {
        		s = "Pagina Principală";
                break;
        	}
            case 1: {
                s = "Informații Dragon";
                break;
            }
            case 2: {
                s = "Adăugare Dragon în Baza de Date";
                break;
            }
            case 3: {
                s = "Ștergere Dragon din Baza de Date";
                break;
            }
            case 4: {
                s = "Vizualizare Dragoni din Baza de Date";
                break;
            }
            case 5: {
                s = "Update Dragon în Baza de Date";
                break;
            }
            case 6: {
                s = "Informații Phoenix";
                break;
            }
            case 7: {
                s = "Adăugare Phoenix în Baza de Date";
                break;
            }
            case 8: {
                s = "Ștergere Phoenix din Baza de Date";
                break;
            }
            case 9: {
                s = "Vizualizare Phoenixi din Baza de Date";
                break;
            }
        }

        Date d = new Date();

        try {
            File file = new File("auditGUI.csv");
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.write(Paths.get("auditGUI.csv"), (s + ", " + d + "\n").getBytes(), StandardOpenOption.APPEND);
        }catch (IOException e) {
            e.printStackTrace();
        }

    }
}
