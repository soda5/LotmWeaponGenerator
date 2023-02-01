package model;

import com.poiji.annotation.ExcelCellName;

public class Downside {
    @ExcelCellName("Schweregrad")
    public int severity;
    @ExcelCellName("Beschreibung")
    public String description;
    @ExcelCellName("Nachteil")
    public String debuff = "keine";

    private String severityText;

    public Downside() {};

    public Downside(int severity, String description, String debuff) {
        this.severity = severity;
        this.description = description;
        if (debuff != null) {
            this.debuff = debuff;
        }

        switch(severity){
            case 0:
                severityText = "Trivial";
                break;
            case 1:
                severityText = "Leicht";
                break;
            case 2:
                severityText = "Mittel";
                break;
            case 3:
                severityText = "Schwer";
                break;
            case 4:
                severityText = "Katastrophal";
                break;
            default:
                System.out.println("Severity Level existiert nicht");
                break;
        }
    }

    public String toString() {
        String finalText = "";
        finalText += "Stufe: " + severityText + "\n";
        finalText += "Beschreibung: " + description + "\n";
        finalText += "Debuff: " + debuff + "\n";
        return finalText;
    }
}
