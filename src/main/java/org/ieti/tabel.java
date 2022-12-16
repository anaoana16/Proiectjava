package org.ieti;

public class tabel {

    private static final String[] COLUMN_NAMES = {"Name of the car brand",
            "Model",
            "Cabin",
            "# of HP",
            "Year of appearance",
    "2 doors"};

    private static final Object[][] DATA = {
            {"Audi", "A4", "Sedan", 280, 2015,false},
            {"BMW", "M6", "Cabriolet", 507, 2006,false},
            {"Lamborghini ", "Gallardo", "Cabriolet", 650, 2017 ,true},
            {"Volkswagen", "Arteon", "Liftback", 280, 2020,false},
            {"Porsche", "Macan", "SUV", 400, 2018,false}
    };

    public static void main(String[] args) {

        JFrame container = new JFrame("Table");
        JTable table = new JTable(DATA, COLUMN_NAMES);
        table.setCellSelectionEnabled(true);

        ListSelectionListenerImpl listSelectionListener = new ListSelectionListenerImpl(table);

        ListSelectionModel select = table.getSelectionModel();
        select.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        select.addListSelectionListener(listSelectionListener);

        JScrollPane scrollPane = new JScrollPane(table);

        container.add(scrollPane);
        container.setLayout(new BorderLayout());
        container.add(table.getTableHeader(), BorderLayout.PAGE_START);
        container.add(table, BorderLayout.CENTER);
        container.setVisible(true);
        container.setSize(300, 400);
    }

}
