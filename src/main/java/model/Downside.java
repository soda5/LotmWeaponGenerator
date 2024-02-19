package model;

import com.poiji.annotation.ExcelCellName;

public class Downside {
    @ExcelCellName("Schweregrad")
    public int severity;
    @ExcelCellName("Titel")
    public String title;
    @ExcelCellName("Beschreibung")
    public String description;
    @ExcelCellName("Nachteil")
    public String debuff = "keine";

    public Downside() {};

    public Downside(int severity, String title, String description, String debuff) {
        this.severity = severity;
        this.title = title;
        this.description = description;
        if (debuff != null) {
            this.debuff = debuff;
        }
    }

    public String toString() {
        String severityText = "";
        switch(severity){
            case 0:
                severityText = String.valueOf(Severity.TRIVIAL);
                break;
            case 1:
                severityText = String.valueOf(Severity.LEICHT);
                break;
            case 2:
                severityText = String.valueOf(Severity.MITTEL);
                break;
            case 3:
                severityText = String.valueOf(Severity.SCHWER);
                break;
            case 4:
                severityText = String.valueOf(Severity.KATASTROPHAL);
                break;
            default:
                System.out.println("Severity Level existiert nicht");
                break;
        }

        String finalText = "";
        finalText += "Stufe: " + severityText + "\n";
        finalText += "Beschreibung: " + description + "\n";
        finalText += "Debuff: " + debuff + "\n";
        return finalText;
    }
}
