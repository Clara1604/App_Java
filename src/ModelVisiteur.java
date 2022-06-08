import javax.swing.table.DefaultTableModel;

import java.util.HashSet;
import java.util.List;
import Entities.*;

public class ModelVisiteur extends DefaultTableModel{

    List<Visiteur> liste;
    String[] colNames = {"Id", "Nom","Prénom"};
    HashSet<Visiteur> modified = new HashSet<>();


    public HashSet<Visiteur> getModified() {
        return modified;
    }

    public void setModified(HashSet<Visiteur> modified) {
        this.modified = modified;
    }

    public ModelVisiteur(List<Entities.Visiteur> visiteurs) {
        liste = visiteurs;
    }

    @Override
    public int getRowCount() {
        return liste == null ? 0 : liste.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return (column !=0);
    }

    @Override
    public Object getValueAt(int row, int column) {
        Object value =null;
        Visiteur v = liste.get(row);
        switch (column) {
            case 0 :
                value = v.getIDVisiteur();
                break;
            case 1 :
                value = v.getNom();
                break;
            case 2 :
                value = v.getPrénom();
                break;
        }

        return value;


    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        // TODO Auto-generated method stub
        Visiteur v = liste.get(row);

        modified.add(v);
    }

    @Override
    public Class getColumnClass(int column)
    {
        for (int row = 0; row < getRowCount(); row++)
        {
            Object o = getValueAt(row, column);

            if (o != null)
            {
                return o.getClass();
            }
        }

        return Object.class;
    }



}