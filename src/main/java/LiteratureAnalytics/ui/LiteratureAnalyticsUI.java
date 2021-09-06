package LiteratureAnalytics.ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.PlainDocument;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.plaf.ColorUIResource;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import org.xml.sax.SAXException;

//Jsoup and Editors imports
import org.bounce.text.LineNumberMargin;
import org.bounce.text.xml.XMLEditorKit;
import org.bounce.text.xml.XMLFoldingMargin;
import org.bounce.text.xml.XMLStyleConstants;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.w3c.dom.*;

//Tablesaw imports
import tech.tablesaw.api.Row;
import tech.tablesaw.api.StringColumn;
import tech.tablesaw.api.Table;
import static tech.tablesaw.api.QuerySupport.or;
import static tech.tablesaw.api.QuerySupport.not;
import static tech.tablesaw.aggregate.AggregateFunctions.*;
import tech.tablesaw.api.ColumnType;
import tech.tablesaw.api.IntColumn;
import tech.tablesaw.api.NumberColumn;
import tech.tablesaw.columns.numbers.NumberColumnFormatter;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.api.BoxPlot;
import tech.tablesaw.plotly.components.Figure;
import tech.tablesaw.plotly.components.Layout;
import tech.tablesaw.plotly.traces.BarTrace;
import tech.tablesaw.plotly.traces.PieTrace;

public class LiteratureAnalyticsUI extends javax.swing.JFrame {

    /**
     * Creates new form LiteratureAnalyticsUI
     */
    public LiteratureAnalyticsUI() {
        initComponents();
    }

    private File myXMLFile;
    private File NumberedFile;
    private XMLEditorKit xmlkit;
    private JTextPane lineNumbers;
    private org.w3c.dom.Document document;
    private NodeList nodelist;
    private Element rootElement;
    private Element Play;
    private Element Title;
    private Element PlayID;
    private Element AuthorID;
    private Element ReleaseDate;
    private Element Genre;
    private Element PlayURL;
    private Element Author;
    private Element AuthorName;
    private Element AuthorBirthDate;
    private Element AuthorBio;
    private Element Contents;
    private Element Introduction;
    private Element Excerpt;
    private Element Comment;
    private Element Characters;
    private Element Act;
    private Element Scene;
    private Element Character;
    private Element CharacterofPlay;
    private Element CharacterName;
    private Element CharacterID;
    private Element Speech;
    private Element StageDirections;
    private String playTitle;
    private int playID;
    private int authorID;
    private int characterID;
    private int id;
    private int actNumber;
    private int sceneNumber;
    private int scenes;
    private List<String> charList = new ArrayList();
    private String crawlURL;
    private String playURL;
    private ArrayList<String> titles = new ArrayList<String>();
    private ArrayList<String> dbTitles = new ArrayList<String>();
    private ArrayList<String> filteredTitles = new ArrayList<String>();
    private ArrayList<String> urls = new ArrayList<String>();
    private ArrayList<String> actsList = new ArrayList<String>();
    private ArrayList<String> scenesList = new ArrayList<String>();
    private ArrayList<String> charactersList = new ArrayList<String>();
    private org.jsoup.nodes.Document scrape;
    private boolean clicked = false;
    private boolean sorted = false;

    public LiteratureAnalyticsUI(File xmlfile, File numberedfile, XMLEditorKit xmlkit, JTextPane numbers, Document mydoc, NodeList mylist) {
        this.myXMLFile = xmlfile;
        this.NumberedFile = numberedfile;
        this.xmlkit = xmlkit;
        this.lineNumbers = numbers;
        this.document = (org.w3c.dom.Document) mydoc;
        this.nodelist = mylist;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        TopPanel = new javax.swing.JPanel();
        SaveButton = new javax.swing.JButton();
        DatabaseButton = new javax.swing.JButton();
        PlayURLLabel = new javax.swing.JLabel();
        SplitPane = new javax.swing.JSplitPane();
        HTMLPanel = new javax.swing.JPanel();
        HTMLScrollPane = new javax.swing.JScrollPane();
        HTMLEditorPane = new javax.swing.JEditorPane();
        HTMLLabel = new javax.swing.JLabel();
        ImportButton = new javax.swing.JButton();
        XMLPanel = new javax.swing.JPanel();
        XMLScrollPane = new javax.swing.JScrollPane();
        XMLEditorPane = new javax.swing.JEditorPane();
        XMLLabel = new javax.swing.JLabel();
        PlayInfoButton = new javax.swing.JButton();
        XMLValidationButton = new javax.swing.JButton();
        FilteringPanel = new javax.swing.JPanel();
        ScenesLabel = new javax.swing.JLabel();
        SceneAnalysisScrollPane = new javax.swing.JScrollPane();
        SceneAnalysisList = new javax.swing.JList<>();
        ActsLabel = new javax.swing.JLabel();
        ActAnalysisScrollPane = new javax.swing.JScrollPane();
        ActAnalysisList = new javax.swing.JList<>();
        CharacterLabel = new javax.swing.JLabel();
        CharacterAnalysisScrollPane = new javax.swing.JScrollPane();
        CharacterAnalysisList = new javax.swing.JList<>();
        WordCountCheckBox = new javax.swing.JCheckBox();
        CrossTabsCheckBox = new javax.swing.JCheckBox();
        CrossPercentCheckBox = new javax.swing.JCheckBox();
        InfoCheckBox = new javax.swing.JCheckBox();
        PlayListPanel = new javax.swing.JPanel();
        PlayListScrollPane = new javax.swing.JScrollPane();
        PlaysList = new javax.swing.JList<>();
        PlaysListLabel = new javax.swing.JLabel();
        DatabasePlaysButton = new javax.swing.JButton();
        SortPlaysButton = new javax.swing.JButton();
        PlaySearchLabel = new javax.swing.JLabel();
        PlaySearchTextField = new javax.swing.JTextField();
        AnalysisPanel = new javax.swing.JPanel();
        PlayLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DataList = new javax.swing.JList<>();
        AnalysisButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        PlayStatisticsCheckBox = new javax.swing.JCheckBox();
        PlayWordCountCheckBox = new javax.swing.JCheckBox();
        PlayCrossTabsCheckBox = new javax.swing.JCheckBox();
        PlayCrossPercentCheckBox = new javax.swing.JCheckBox();
        PlotComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        TopPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ανάλυση Δεδομένων Θεατρικών Έργων", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 14))); // NOI18N

        SaveButton.setBackground(new java.awt.Color(255, 153, 0));
        SaveButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SaveButton.setText("Εξαγωγή XML");
        SaveButton.setEnabled(false);
        SaveButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SaveButtonActionPerformed(evt);
            }
        });

        DatabaseButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DatabaseButton.setText("Εισαγωγή στη Βάση");
        DatabaseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatabaseButtonActionPerformed(evt);
            }
        });

        PlayURLLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlayURLLabelMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout TopPanelLayout = new javax.swing.GroupLayout(TopPanel);
        TopPanel.setLayout(TopPanelLayout);
        TopPanelLayout.setHorizontalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(PlayURLLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(DatabaseButton)
                .addGap(382, 382, 382)
                .addComponent(SaveButton)
                .addContainerGap())
        );
        TopPanelLayout.setVerticalGroup(
            TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(TopPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(SaveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(DatabaseButton)
                .addComponent(PlayURLLabel))
        );

        HTMLPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        HTMLPanel.setMaximumSize(new java.awt.Dimension(5000, 5000));
        HTMLPanel.setPreferredSize(new java.awt.Dimension(450, 565));

        HTMLEditorPane.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        HTMLEditorPane.setMaximumSize(new java.awt.Dimension(5000, 5000));
        HTMLEditorPane.setPreferredSize(new java.awt.Dimension(500, 26));
        HTMLScrollPane.setViewportView(HTMLEditorPane);

        HTMLLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        HTMLLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        HTMLLabel.setText(" HTML ");
        HTMLLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ImportButton.setBackground(new java.awt.Color(51, 255, 51));
        ImportButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        ImportButton.setText("Εισαγωγή");
        ImportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout HTMLPanelLayout = new javax.swing.GroupLayout(HTMLPanel);
        HTMLPanel.setLayout(HTMLPanelLayout);
        HTMLPanelLayout.setHorizontalGroup(
            HTMLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HTMLPanelLayout.createSequentialGroup()
                .addComponent(ImportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 342, Short.MAX_VALUE))
            .addGroup(HTMLPanelLayout.createSequentialGroup()
                .addComponent(HTMLLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(HTMLScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        HTMLPanelLayout.setVerticalGroup(
            HTMLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(HTMLPanelLayout.createSequentialGroup()
                .addComponent(HTMLLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(HTMLScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ImportButton)
                .addContainerGap())
        );

        HTMLLabel.getAccessibleContext().setAccessibleName("Outline");

        SplitPane.setLeftComponent(HTMLPanel);
        HTMLPanel.getAccessibleContext().setAccessibleName("Δομή Κειμένου");

        XMLPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        XMLPanel.setMaximumSize(new java.awt.Dimension(5000, 5000));

        XMLEditorPane.setMaximumSize(new java.awt.Dimension(5000, 5000));
        XMLScrollPane.setViewportView(XMLEditorPane);

        XMLLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        XMLLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        XMLLabel.setText(" XML ");
        XMLLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PlayInfoButton.setBackground(new java.awt.Color(255, 255, 0));
        PlayInfoButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        PlayInfoButton.setText("Πληροφορίες");
        PlayInfoButton.setEnabled(false);
        PlayInfoButton.setMaximumSize(new java.awt.Dimension(95, 25));
        PlayInfoButton.setMinimumSize(new java.awt.Dimension(95, 25));
        PlayInfoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlayInfoButtonActionPerformed(evt);
            }
        });

        XMLValidationButton.setBackground(new java.awt.Color(51, 255, 204));
        XMLValidationButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        XMLValidationButton.setText("Έλεγχος XML ");
        XMLValidationButton.setEnabled(false);
        XMLValidationButton.setMaximumSize(new java.awt.Dimension(95, 25));
        XMLValidationButton.setMinimumSize(new java.awt.Dimension(95, 25));
        XMLValidationButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                XMLValidationButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout XMLPanelLayout = new javax.swing.GroupLayout(XMLPanel);
        XMLPanel.setLayout(XMLPanelLayout);
        XMLPanelLayout.setHorizontalGroup(
            XMLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(XMLPanelLayout.createSequentialGroup()
                .addComponent(XMLLabel)
                .addContainerGap(369, Short.MAX_VALUE))
            .addComponent(XMLScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
            .addGroup(XMLPanelLayout.createSequentialGroup()
                .addComponent(XMLValidationButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(PlayInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        XMLPanelLayout.setVerticalGroup(
            XMLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, XMLPanelLayout.createSequentialGroup()
                .addComponent(XMLLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(XMLScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(XMLPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(XMLValidationButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PlayInfoButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        SplitPane.setRightComponent(XMLPanel);

        FilteringPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        ScenesLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        ScenesLabel.setText(" Σκηνές ");
        ScenesLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        SceneAnalysisList.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        SceneAnalysisList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        SceneAnalysisList.setEnabled(false);
        SceneAnalysisScrollPane.setViewportView(SceneAnalysisList);

        ActsLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        ActsLabel.setText(" Πράξεις ");
        ActsLabel.setToolTipText("");
        ActsLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ActAnalysisList.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        ActAnalysisList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ActAnalysisList.setEnabled(false);
        ActAnalysisScrollPane.setViewportView(ActAnalysisList);

        CharacterLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        CharacterLabel.setText(" Χαρακτήρες ");
        CharacterLabel.setToolTipText("");
        CharacterLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        CharacterAnalysisList.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        CharacterAnalysisList.setEnabled(false);
        CharacterAnalysisScrollPane.setViewportView(CharacterAnalysisList);

        WordCountCheckBox.setText("ΑΡΙΘΜΟΣ ΛΕΞΕΩΝ");

        CrossTabsCheckBox.setText("CROSS TABULATION");

        CrossPercentCheckBox.setText("CROSS TABS (%)");

        InfoCheckBox.setText("ΠΛΗΡΟΦΟΡΙΕΣ");

        javax.swing.GroupLayout FilteringPanelLayout = new javax.swing.GroupLayout(FilteringPanel);
        FilteringPanel.setLayout(FilteringPanelLayout);
        FilteringPanelLayout.setHorizontalGroup(
            FilteringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FilteringPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FilteringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ActsLabel)
                    .addComponent(ActAnalysisScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addGroup(FilteringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ScenesLabel)
                    .addComponent(SceneAnalysisScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(FilteringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FilteringPanelLayout.createSequentialGroup()
                        .addComponent(CharacterLabel)
                        .addGap(0, 40, Short.MAX_VALUE))
                    .addComponent(CharacterAnalysisScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FilteringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(WordCountCheckBox)
                    .addComponent(CrossTabsCheckBox)
                    .addComponent(CrossPercentCheckBox)
                    .addComponent(InfoCheckBox))
                .addGap(18, 18, 18))
        );
        FilteringPanelLayout.setVerticalGroup(
            FilteringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FilteringPanelLayout.createSequentialGroup()
                .addComponent(InfoCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(WordCountCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CrossTabsCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CrossPercentCheckBox)
                .addGap(8, 8, 8))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FilteringPanelLayout.createSequentialGroup()
                .addGroup(FilteringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CharacterLabel)
                    .addComponent(ActsLabel)
                    .addComponent(ScenesLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(FilteringPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SceneAnalysisScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CharacterAnalysisScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ActAnalysisScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        PlayListPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        PlaysList.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                PlaysListMouseDragged(evt);
            }
        });
        PlaysList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                PlaysListMouseClicked(evt);
            }
        });
        PlayListScrollPane.setViewportView(PlaysList);

        PlaysListLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        PlaysListLabel.setText(" Θεατρικά Έργα ");
        PlaysListLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        DatabasePlaysButton.setBackground(new java.awt.Color(102, 255, 204));
        DatabasePlaysButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        DatabasePlaysButton.setText("D");
        DatabasePlaysButton.setMargin(new java.awt.Insets(2, 0, 2, 0));
        DatabasePlaysButton.setMaximumSize(new java.awt.Dimension(33, 25));
        DatabasePlaysButton.setMinimumSize(new java.awt.Dimension(33, 25));
        DatabasePlaysButton.setPreferredSize(new java.awt.Dimension(33, 25));
        DatabasePlaysButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatabasePlaysButtonActionPerformed(evt);
            }
        });

        SortPlaysButton.setBackground(new java.awt.Color(255, 255, 0));
        SortPlaysButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        SortPlaysButton.setText("Τ");
        SortPlaysButton.setMargin(new java.awt.Insets(2, 0, 2, 0));
        SortPlaysButton.setMaximumSize(new java.awt.Dimension(33, 25));
        SortPlaysButton.setMinimumSize(new java.awt.Dimension(33, 25));
        SortPlaysButton.setPreferredSize(new java.awt.Dimension(33, 25));
        SortPlaysButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SortPlaysButtonActionPerformed(evt);
            }
        });

        PlaySearchLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        PlaySearchLabel.setText("Αναζήτηση:");

        PlaySearchTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PlaySearchTextFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PlayListPanelLayout = new javax.swing.GroupLayout(PlayListPanel);
        PlayListPanel.setLayout(PlayListPanelLayout);
        PlayListPanelLayout.setHorizontalGroup(
            PlayListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PlayListPanelLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(PlayListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(PlaysListLabel)
                    .addGroup(PlayListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(PlayListPanelLayout.createSequentialGroup()
                            .addComponent(PlaySearchLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(PlaySearchTextField)
                            .addGap(7, 7, 7)
                            .addComponent(DatabasePlaysButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(SortPlaysButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(PlayListScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE))))
        );
        PlayListPanelLayout.setVerticalGroup(
            PlayListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PlayListPanelLayout.createSequentialGroup()
                .addComponent(PlaysListLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PlayListScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(PlayListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SortPlaysButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(PlayListPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(DatabasePlaysButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PlaySearchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(PlaySearchLabel)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        AnalysisPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        PlayLabel.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        PlayLabel.setText(" Δεδομένα ");
        PlayLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        DataList.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        DataList.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { " " };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(DataList);

        AnalysisButton.setBackground(new java.awt.Color(102, 153, 255));
        AnalysisButton.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        AnalysisButton.setText("Ανάλυση");
        AnalysisButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AnalysisButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 16)); // NOI18N
        jLabel1.setText(" Διάγραμμα ");
        jLabel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        PlayStatisticsCheckBox.setText("ΠΛΗΡΟΦΟΡΙΕΣ");

        PlayWordCountCheckBox.setText("ΑΡΙΘΜΟΣ ΛΕΞΕΩΝ");

        PlayCrossTabsCheckBox.setText("CROSS TABULATION");

        PlayCrossPercentCheckBox.setText("CROSS TABS (%)");

        PlotComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Πίτα", "Ραβδόγραμμα" }));

        javax.swing.GroupLayout AnalysisPanelLayout = new javax.swing.GroupLayout(AnalysisPanel);
        AnalysisPanel.setLayout(AnalysisPanelLayout);
        AnalysisPanelLayout.setHorizontalGroup(
            AnalysisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AnalysisPanelLayout.createSequentialGroup()
                .addComponent(PlayLabel)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(AnalysisPanelLayout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(AnalysisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AnalysisPanelLayout.createSequentialGroup()
                        .addComponent(PlayCrossPercentCheckBox)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AnalysisButton, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(AnalysisPanelLayout.createSequentialGroup()
                        .addGroup(AnalysisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(PlayCrossTabsCheckBox)
                            .addGroup(AnalysisPanelLayout.createSequentialGroup()
                                .addGroup(AnalysisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PlayStatisticsCheckBox)
                                    .addComponent(PlayWordCountCheckBox))
                                .addGap(34, 34, 34)
                                .addGroup(AnalysisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(PlotComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())))
        );
        AnalysisPanelLayout.setVerticalGroup(
            AnalysisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(AnalysisPanelLayout.createSequentialGroup()
                .addGroup(AnalysisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(PlayLabel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(AnalysisPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(AnalysisPanelLayout.createSequentialGroup()
                        .addComponent(PlotComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(AnalysisButton))
                    .addGroup(AnalysisPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(AnalysisPanelLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(PlayStatisticsCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PlayWordCountCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PlayCrossTabsCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PlayCrossPercentCheckBox)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(TopPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(PlayListPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SplitPane))
            .addGroup(layout.createSequentialGroup()
                .addComponent(FilteringPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AnalysisPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(TopPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(SplitPane, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(PlayListPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(FilteringPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(AnalysisPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getAccessibleContext().setAccessibleName("Frame");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void AnalysisButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AnalysisButtonActionPerformed

        String dbUrl = "jdbc:mysql://localhost/theatrical_plays?useUnicode=true&character_set_server=utf8mb4&characterEncoding=UTF-8";
        String username = "root";
        String password = "root123456";
        //File stylesheet = new File("C:\\Users\\ΔΗΜΗΤΡΗΣ\\Desktop\\style.xsl");
        String replace = XMLEditorPane.getText();
        replace = replace.replaceAll(",", "").replaceAll("&amp;", "").replaceAll("&gt;", "").replaceAll(";", "");

        if (XMLEditorPane.getText().isEmpty()) {
            String dialog = "Άδειο Κείμενο";
            JOptionPane.showMessageDialog(new JFrame(), "Το κείμενο είναι άδειο!", dialog, JOptionPane.ERROR_MESSAGE);
        } else {
            PrintWriter writer = null;
            try {
                //Clear file contents
                writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(myXMLFile, false), StandardCharsets.UTF_8));
                //Write to file
                writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(myXMLFile, true), StandardCharsets.UTF_8));
                writer.println(replace);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            writer.close();
        }

        try {
            //Create connection
            java.sql.Connection con = DriverManager.getConnection(dbUrl, username, password);

            List<String> selectedActs = ActAnalysisList.getSelectedValuesList();
            List<String> selectedScenes = SceneAnalysisList.getSelectedValuesList();
            List<String> selectedCharacters = CharacterAnalysisList.getSelectedValuesList();
            int characterId = 0;
            ArrayList<Integer> charactersId = new ArrayList<Integer>();
            ArrayList<String> dialogue = new ArrayList<String>();
            ArrayList<String> stageDirections = new ArrayList<String>();
            Table acts = null;
            Table scenes = null;
            Table characters = null;
            Table charactersinAct = null;
            Table charactersinScene = null;

            //ONLY ACT SELECTION
            //ONE ACT
            if (selectedActs != null && selectedActs.size() == 1 && selectedScenes.isEmpty() && selectedCharacters.isEmpty()) {
                //GET CHARACTERS OF ACT
                PreparedStatement actResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες, Πράξη FROM διάλογοι WHERE Πράξη = ?"
                        + "AND Έργο = ?");
                actResult.setString(1, selectedActs.get(0).replaceAll("ACT ", ""));
                actResult.setInt(2, playID);
                ResultSet actRS = actResult.executeQuery();
                //Create Table
                acts = Table.read().db(actRS);
                System.out.println("Characters in " + selectedActs.get(0) + " Table: " + acts);

                //STATISTICS
                if (InfoCheckBox.isSelected()) {
                    int sceneCount = 0;
                    int characterCount = 0;
                    int dialogueCount = 0;
                    //COUNT SCENES
                    if (scenesList.get(0).equals("0") == false) {
                        PreparedStatement countsceneResult = con.prepareStatement("SELECT COUNT(DISTINCT Σκηνή) FROM διάλογοι WHERE Πράξη = ?"
                                + "AND Έργο = ?");
                        countsceneResult.setString(1, selectedActs.get(0).replaceAll("ACT ", ""));
                        countsceneResult.setInt(2, playID);
                        ResultSet countsceneRS = countsceneResult.executeQuery();
                        if (countsceneRS.next()) {
                            sceneCount = countsceneRS.getInt("COUNT(DISTINCT Σκηνή)");
                        }
                    }
                    //COUNT CHARACTERS
                    PreparedStatement countcharactersResult = con.prepareStatement("SELECT COUNT(DISTINCT Όνομα) FROM διάλογοι WHERE Πράξη = ?"
                            + "AND Έργο = ?");
                    countcharactersResult.setString(1, selectedActs.get(0).replaceAll("ACT ", ""));
                    countcharactersResult.setInt(2, playID);
                    ResultSet countcharactersRS = countcharactersResult.executeQuery();
                    if (countcharactersRS.next()) {
                        characterCount = countcharactersRS.getInt("COUNT(DISTINCT Όνομα)");
                    }
                    //COUNT DIALOGUE
                    PreparedStatement countdialogueResult = con.prepareStatement("SELECT COUNT(Διάλογος) FROM διάλογοι WHERE Πράξη = ?"
                            + "AND Έργο = ?");
                    countdialogueResult.setString(1, selectedActs.get(0).replaceAll("ACT ", ""));
                    countdialogueResult.setInt(2, playID);
                    ResultSet countdialogueRS = countdialogueResult.executeQuery();
                    if (countdialogueRS.next()) {
                        dialogueCount = countdialogueRS.getInt("COUNT(Διάλογος)");
                    }
                    if (scenesList.get(0).equals("0") == false) {
                        String statisticsMessage = "<HTML><BODY><P>Σύνολο Σκηνών: <B>" + sceneCount + "</B><BR>"
                                + "Σύνολο Χαρακτήρων: <B>" + characterCount + "</B><BR>"
                                + "Σύνολο Διαλόγων: <B>" + dialogueCount + "</B><BR></P></BODY></HTML>";
                        JOptionPane.showMessageDialog(this, statisticsMessage, "Στατιστικά", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        String statisticsMessage = "<HTML><BODY><P>Σύνολο Χαρακτήρων: <B>" + characterCount + "</B><BR>"
                                + "Σύνολο Διαλόγων: <B>" + dialogueCount + "</B><BR></P></BODY></HTML>";
                        JOptionPane.showMessageDialog(this, statisticsMessage, "Στατιστικά", JOptionPane.INFORMATION_MESSAGE);
                    }

                }

                //WORD COUNT
                if (WordCountCheckBox.isSelected()) {
                    int dialogueCounter = 0;
                    int stagedirectionsCounter = 0;
                    PreparedStatement wordCountResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες FROM διάλογοι WHERE Πράξη = ?"
                            + "AND Έργο = ?");
                    wordCountResult.setString(1, selectedActs.get(0).replaceAll("ACT ", ""));
                    wordCountResult.setInt(2, playID);
                    ResultSet wordCountRS = wordCountResult.executeQuery();
                    while (wordCountRS.next()) {
                        dialogue.add(wordCountRS.getString("Διάλογος"));
                        stageDirections.add(wordCountRS.getString("Σκηνικές_Οδηγίες"));
                    }
                    for (int i = 0; i < dialogue.size(); i++) {
                        if (dialogue.get(i).isEmpty() == false) {
                            int count = wordCounter(dialogue.get(i));
                            dialogueCounter += count;
                        }
                    }
                    for (int i = 0; i < stageDirections.size(); i++) {
                        if (stageDirections.get(i).isEmpty() == false) {
                            int count = wordCounter(stageDirections.get(i));
                            stagedirectionsCounter += count;
                        }
                    }
                    String message2 = "<HTML><BODY><P>Αριθμός Λέξεων Διαλόγων:  <B>" + dialogueCounter + "</B><BR><BR>"
                            + "<P>Αριθμος Λέξεων Σκηνικών Οδηγιών: <B>" + stagedirectionsCounter + "</B></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, message2, "Διάλογοι και Σκηνικές Οδηγίες", JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS
                if (CrossTabsCheckBox.isSelected()) {
                    Table tabs = acts.xTabCounts("Όνομα", "Πράξη");
                    String info = "Χαρακτήρες x Πράξη Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(350, 400));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS (%)
                if (CrossPercentCheckBox.isSelected()) {
                    Table tabs = acts.xTabTablePercents("Όνομα", "Πράξη");
                    tabs.columnsOfType(ColumnType.DOUBLE).forEach(x -> ((NumberColumn) x).setPrintFormatter(NumberColumnFormatter.percent(2)));
                    String info = "Χαρακτήρες x Πράξη Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(350, 400));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }

                //PLOTS
                Table t = acts.xTabCounts("Όνομα");
                //Pie Chart
                if (PlotComboBox.getSelectedItem().equals("Πίτα")) {
                    Layout layout = Layout.builder().title("ΧΑΡΑΚΤΗΡΕΣ ΠΡΑΞΗΣ " + selectedActs.get(0).replaceAll("ACT ", "")).height(600).width(1200).build();
                    PieTrace trace = PieTrace.builder(t.column("Category"), t.numberColumn("Count")).showLegend(true).build();
                    Plot.show(new Figure(layout, trace));
                    //Bar Chart    
                } else if (PlotComboBox.getSelectedItem().equals("Ραβδόγραμμα")) {
                    Layout layout = Layout.builder().title("ΧΑΡΑΚΤΗΡΕΣ ΠΡΑΞΗΣ " + selectedActs.get(0).replaceAll("ACT ", "")).height(600).width(1200).build();
                    BarTrace trace = BarTrace.builder(t.categoricalColumn("Category"), t.numberColumn("Count")).showLegend(true).build();
                    Plot.show(new Figure(layout, trace));
                }
            }
            //TWO ACTS
            if (selectedActs != null && selectedActs.size() == 2 && selectedScenes.isEmpty() && selectedCharacters.isEmpty()) {
                //GET CHARACTERS OF ACT
                PreparedStatement actResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες, Πράξη FROM διάλογοι WHERE (Πράξη = ?"
                        + "OR Πράξη = ?) AND Έργο = ?");
                actResult.setString(1, selectedActs.get(0).replaceAll("ACT ", ""));
                actResult.setString(2, selectedActs.get(1).replaceAll("ACT ", ""));
                actResult.setInt(3, playID);
                ResultSet actRS = actResult.executeQuery();
                //Create Table
                acts = Table.read().db(actRS);
                System.out.println("Characters in " + selectedActs.get(0) + " Table: " + acts);

                //STATISTICS
                if (InfoCheckBox.isSelected()) {
                    int sceneCount = 0;
                    int characterCount = 0;
                    int dialogueCount = 0;
                    //COUNT SCENES
                    if (scenesList.get(0).equals("0") == false) {
                        PreparedStatement countsceneResult = con.prepareStatement("SELECT COUNT(DISTINCT Σκηνή) FROM διάλογοι WHERE (Πράξη = ?"
                                + "OR Πράξη = ?) AND Έργο = ?");
                        countsceneResult.setString(1, selectedActs.get(0).replaceAll("ACT ", ""));
                        countsceneResult.setString(2, selectedActs.get(1).replaceAll("ACT ", ""));
                        countsceneResult.setInt(3, playID);
                        ResultSet countsceneRS = countsceneResult.executeQuery();
                        if (countsceneRS.next()) {
                            sceneCount = countsceneRS.getInt("COUNT(DISTINCT Σκηνή)");
                        }
                    }
                    //COUNT CHARACTERS
                    PreparedStatement countcharactersResult = con.prepareStatement("SELECT COUNT(DISTINCT Όνομα) FROM διάλογοι WHERE (Πράξη = ?"
                            + "OR Πράξη = ?) AND Έργο = ?");
                    countcharactersResult.setString(1, selectedActs.get(0).replaceAll("ACT ", ""));
                    countcharactersResult.setString(2, selectedActs.get(1).replaceAll("ACT ", ""));
                    countcharactersResult.setInt(3, playID);
                    ResultSet countcharactersRS = countcharactersResult.executeQuery();
                    if (countcharactersRS.next()) {
                        characterCount = countcharactersRS.getInt("COUNT(DISTINCT Όνομα)");
                    }
                    //COUNT DIALOGUE
                    PreparedStatement countdialogueResult = con.prepareStatement("SELECT COUNT(Διάλογος) FROM διάλογοι WHERE (Πράξη = ?"
                            + "OR Πράξη = ?) AND Έργο = ?");
                    countdialogueResult.setString(1, selectedActs.get(0).replaceAll("ACT ", ""));
                    countdialogueResult.setString(2, selectedActs.get(1).replaceAll("ACT ", ""));
                    countdialogueResult.setInt(3, playID);
                    ResultSet countdialogueRS = countdialogueResult.executeQuery();
                    if (countdialogueRS.next()) {
                        dialogueCount = countdialogueRS.getInt("COUNT(Διάλογος)");
                    }
                    if (scenesList.get(0).equals("0") == false) {
                        String statisticsMessage = "<HTML><BODY><P>Σύνολο Σκηνών: <B>" + sceneCount + "</B><BR>"
                                + "Σύνολο Χαρακτήρων: <B>" + characterCount + "</B><BR>"
                                + "Σύνολο Διαλόγων: <B>" + dialogueCount + "</B><BR></P></BODY></HTML>";
                        JOptionPane.showMessageDialog(this, statisticsMessage, "Στατιστικά", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        String statisticsMessage = "<HTML><BODY><P>Σύνολο Χαρακτήρων: <B>" + characterCount + "</B><BR>"
                                + "Σύνολο Διαλόγων: <B>" + dialogueCount + "</B><BR></P></BODY></HTML>";
                        JOptionPane.showMessageDialog(this, statisticsMessage, "Στατιστικά", JOptionPane.INFORMATION_MESSAGE);
                    }

                }

                //WORD COUNT
                if (WordCountCheckBox.isSelected()) {
                    int dialogueCounter = 0;
                    int stagedirectionsCounter = 0;
                    PreparedStatement wordCountResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες FROM διάλογοι WHERE (Πράξη = ?"
                            + "OR Πράξη = ?) AND Έργο = ?");
                    wordCountResult.setString(1, selectedActs.get(0).replaceAll("ACT ", ""));
                    wordCountResult.setString(2, selectedActs.get(1).replaceAll("ACT ", ""));
                    wordCountResult.setInt(3, playID);
                    ResultSet wordCountRS = wordCountResult.executeQuery();
                    while (wordCountRS.next()) {
                        dialogue.add(wordCountRS.getString("Διάλογος"));
                        stageDirections.add(wordCountRS.getString("Σκηνικές_Οδηγίες"));
                    }
                    for (int i = 0; i < dialogue.size(); i++) {
                        if (dialogue.get(i).isEmpty() == false) {
                            int count = wordCounter(dialogue.get(i));
                            dialogueCounter += count;
                        }
                    }
                    for (int i = 0; i < stageDirections.size(); i++) {
                        if (stageDirections.get(i).isEmpty() == false) {
                            int count = wordCounter(stageDirections.get(i));
                            stagedirectionsCounter += count;
                        }
                    }
                    String message2 = "<HTML><BODY><P>Αριθμός Λέξεων Διαλόγων:  <B>" + dialogueCounter + "</B><BR><BR>"
                            + "<P>Αριθμος Λέξεων Σκηνικών Οδηγιών: <B>" + stagedirectionsCounter + "</B></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, message2, "Διάλογοι και Σκηνικές Οδηγίες", JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS
                if (CrossTabsCheckBox.isSelected()) {
                    Table tabs = acts.xTabCounts("Όνομα", "Πράξη");
                    String info = "Χαρακτήρες x Πράξη Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(350, 400));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS (%)
                if (CrossPercentCheckBox.isSelected()) {
                    Table tabs = acts.xTabTablePercents("Όνομα", "Πράξη");
                    tabs.columnsOfType(ColumnType.DOUBLE).forEach(x -> ((NumberColumn) x).setPrintFormatter(NumberColumnFormatter.percent(2)));
                    String info = "Χαρακτήρες x Πράξη Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(350, 400));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }

                //PLOTS
                Table t = acts.xTabCounts("Όνομα");
                //Pie Chart
                if (PlotComboBox.getSelectedItem().equals("Πίτα")) {
                    Layout layout = Layout.builder().title("ΧΑΡΑΚΤΗΡΕΣ ΠΡΑΞΗΣ " + selectedActs.get(0).replaceAll("ACT ", "")).height(600).width(1200).build();
                    PieTrace trace = PieTrace.builder(t.column("Category"), t.numberColumn("Count")).showLegend(true).build();
                    Plot.show(new Figure(layout, trace));
                    //Bar Chart    
                } else if (PlotComboBox.getSelectedItem().equals("Ραβδόγραμμα")) {
                    Layout layout = Layout.builder().title("ΧΑΡΑΚΤΗΡΕΣ ΠΡΑΞΗΣ " + selectedActs.get(0).replaceAll("ACT ", "")).height(600).width(1200).build();
                    BarTrace trace = BarTrace.builder(t.categoricalColumn("Category"), t.numberColumn("Count")).showLegend(true).build();
                    Plot.show(new Figure(layout, trace));
                }
            }
            //THREE ACTS
            if (selectedActs != null && selectedActs.size() == 3 && selectedScenes.isEmpty() && selectedCharacters.isEmpty()) {
                //GET CHARACTERS OF ACT
                PreparedStatement actResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες, Πράξη FROM διάλογοι WHERE (Πράξη = ?"
                        + "OR Πράξη = ? OR Πράξη = ?) AND Έργο = ?");
                actResult.setString(1, selectedActs.get(0).replaceAll("ACT ", ""));
                actResult.setString(2, selectedActs.get(1).replaceAll("ACT ", ""));
                actResult.setString(3, selectedActs.get(2).replaceAll("ACT ", ""));
                actResult.setInt(4, playID);
                ResultSet actRS = actResult.executeQuery();
                //Create Table
                acts = Table.read().db(actRS);
                System.out.println("Characters in " + selectedActs.get(0) + " Table: " + acts);

                //STATISTICS
                if (InfoCheckBox.isSelected()) {
                    int sceneCount = 0;
                    int characterCount = 0;
                    int dialogueCount = 0;
                    //COUNT SCENES
                    if (scenesList.get(0).equals("0") == false) {
                        PreparedStatement countsceneResult = con.prepareStatement("SELECT COUNT(DISTINCT Σκηνή) FROM διάλογοι WHERE (Πράξη = ?"
                                + "OR Πράξη = ? OR Πράξη = ?) AND Έργο = ?");
                        countsceneResult.setString(1, selectedActs.get(0).replaceAll("ACT ", ""));
                        countsceneResult.setString(2, selectedActs.get(1).replaceAll("ACT ", ""));
                        countsceneResult.setString(3, selectedActs.get(2).replaceAll("ACT ", ""));
                        countsceneResult.setInt(4, playID);
                        ResultSet countsceneRS = countsceneResult.executeQuery();
                        if (countsceneRS.next()) {
                            sceneCount = countsceneRS.getInt("COUNT(DISTINCT Σκηνή)");
                        }
                    }
                    //COUNT CHARACTERS
                    PreparedStatement countcharactersResult = con.prepareStatement("SELECT COUNT(DISTINCT Όνομα) FROM διάλογοι WHERE (Πράξη = ?"
                            + "OR Πράξη = ? OR Πράξη = ?) AND Έργο = ?");
                    countcharactersResult.setString(1, selectedActs.get(0).replaceAll("ACT ", ""));
                    countcharactersResult.setString(2, selectedActs.get(1).replaceAll("ACT ", ""));
                    countcharactersResult.setString(3, selectedActs.get(2).replaceAll("ACT ", ""));
                    countcharactersResult.setInt(4, playID);
                    ResultSet countcharactersRS = countcharactersResult.executeQuery();
                    if (countcharactersRS.next()) {
                        characterCount = countcharactersRS.getInt("COUNT(DISTINCT Όνομα)");
                    }
                    //COUNT DIALOGUE
                    PreparedStatement countdialogueResult = con.prepareStatement("SELECT COUNT(Διάλογος) FROM διάλογοι WHERE (Πράξη = ?"
                            + "OR Πράξη = ? OR Πράξη = ?) AND Έργο = ?");
                    countdialogueResult.setString(1, selectedActs.get(0).replaceAll("ACT ", ""));
                    countdialogueResult.setString(2, selectedActs.get(1).replaceAll("ACT ", ""));
                    countdialogueResult.setString(3, selectedActs.get(2).replaceAll("ACT ", ""));
                    countdialogueResult.setInt(4, playID);
                    ResultSet countdialogueRS = countdialogueResult.executeQuery();
                    if (countdialogueRS.next()) {
                        dialogueCount = countdialogueRS.getInt("COUNT(Διάλογος)");
                    }
                    if (scenesList.get(0).equals("0") == false) {
                        String statisticsMessage = "<HTML><BODY><P>Σύνολο Σκηνών: <B>" + sceneCount + "</B><BR>"
                                + "Σύνολο Χαρακτήρων: <B>" + characterCount + "</B><BR>"
                                + "Σύνολο Διαλόγων: <B>" + dialogueCount + "</B><BR></P></BODY></HTML>";
                        JOptionPane.showMessageDialog(this, statisticsMessage, "Στατιστικά", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        String statisticsMessage = "<HTML><BODY><P>Σύνολο Χαρακτήρων: <B>" + characterCount + "</B><BR>"
                                + "Σύνολο Διαλόγων: <B>" + dialogueCount + "</B><BR></P></BODY></HTML>";
                        JOptionPane.showMessageDialog(this, statisticsMessage, "Στατιστικά", JOptionPane.INFORMATION_MESSAGE);
                    }

                }

                //WORD COUNT
                if (WordCountCheckBox.isSelected()) {
                    int dialogueCounter = 0;
                    int stagedirectionsCounter = 0;
                    PreparedStatement wordCountResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες FROM διάλογοι WHERE (Πράξη = ?"
                            + "OR Πράξη = ? OR Πράξη = ?) AND Έργο = ?");
                    wordCountResult.setString(1, selectedActs.get(0).replaceAll("ACT ", ""));
                    wordCountResult.setString(2, selectedActs.get(1).replaceAll("ACT ", ""));
                    wordCountResult.setString(3, selectedActs.get(2).replaceAll("ACT ", ""));
                    wordCountResult.setInt(4, playID);
                    ResultSet wordCountRS = wordCountResult.executeQuery();
                    while (wordCountRS.next()) {
                        dialogue.add(wordCountRS.getString("Διάλογος"));
                        stageDirections.add(wordCountRS.getString("Σκηνικές_Οδηγίες"));
                    }
                    for (int i = 0; i < dialogue.size(); i++) {
                        if (dialogue.get(i).isEmpty() == false) {
                            int count = wordCounter(dialogue.get(i));
                            dialogueCounter += count;
                        }
                    }
                    for (int i = 0; i < stageDirections.size(); i++) {
                        if (stageDirections.get(i).isEmpty() == false) {
                            int count = wordCounter(stageDirections.get(i));
                            stagedirectionsCounter += count;
                        }
                    }
                    String message2 = "<HTML><BODY><P>Αριθμός Λέξεων Διαλόγων:  <B>" + dialogueCounter + "</B><BR><BR>"
                            + "<P>Αριθμος Λέξεων Σκηνικών Οδηγιών: <B>" + stagedirectionsCounter + "</B></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, message2, "Διάλογοι και Σκηνικές Οδηγίες", JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS
                if (CrossTabsCheckBox.isSelected()) {
                    Table tabs = acts.xTabCounts("Όνομα", "Πράξη");
                    String info = "Χαρακτήρες x Πράξη Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(500, 400));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS (%)
                if (CrossPercentCheckBox.isSelected()) {
                    Table tabs = acts.xTabTablePercents("Όνομα", "Πράξη");
                    tabs.columnsOfType(ColumnType.DOUBLE).forEach(x -> ((NumberColumn) x).setPrintFormatter(NumberColumnFormatter.percent(2)));
                    String info = "Χαρακτήρες x Πράξη Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(500, 400));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }

                //PLOTS
                Table t = acts.xTabCounts("Όνομα");
                //Pie Chart
                if (PlotComboBox.getSelectedItem().equals("Πίτα")) {
                    Layout layout = Layout.builder().title("ΧΑΡΑΚΤΗΡΕΣ ΠΡΑΞΗΣ " + selectedActs.get(0).replaceAll("ACT ", "")).height(600).width(1200).build();
                    PieTrace trace = PieTrace.builder(t.column("Category"), t.numberColumn("Count")).showLegend(true).build();
                    Plot.show(new Figure(layout, trace));
                    //Bar Chart    
                } else if (PlotComboBox.getSelectedItem().equals("Ραβδόγραμμα")) {
                    Layout layout = Layout.builder().title("ΧΑΡΑΚΤΗΡΕΣ ΠΡΑΞΗΣ " + selectedActs.get(0).replaceAll("ACT ", "")).height(600).width(1200).build();
                    BarTrace trace = BarTrace.builder(t.categoricalColumn("Category"), t.numberColumn("Count")).showLegend(true).build();
                    Plot.show(new Figure(layout, trace));
                }
            }
            //FOUR ACTS
            if (selectedActs != null && selectedActs.size() == 4 && selectedScenes.isEmpty() && selectedCharacters.isEmpty()) {
                //GET CHARACTERS OF ACT
                PreparedStatement actResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες, Πράξη FROM διάλογοι WHERE (Πράξη = ?"
                        + "OR Πράξη = ? OR Πράξη = ? OR Πράξη = ?) AND Έργο = ?");
                actResult.setString(1, selectedActs.get(0).replaceAll("ACT ", ""));
                actResult.setString(2, selectedActs.get(1).replaceAll("ACT ", ""));
                actResult.setString(3, selectedActs.get(2).replaceAll("ACT ", ""));
                actResult.setString(4, selectedActs.get(3).replaceAll("ACT ", ""));
                actResult.setInt(5, playID);
                ResultSet actRS = actResult.executeQuery();
                //Create Table
                acts = Table.read().db(actRS);
                System.out.println("Characters in " + selectedActs.get(0) + " Table: " + acts);

                //STATISTICS
                if (InfoCheckBox.isSelected()) {
                    int sceneCount = 0;
                    int characterCount = 0;
                    int dialogueCount = 0;
                    //COUNT SCENES
                    if (scenesList.get(0).equals("0") == false) {
                        PreparedStatement countsceneResult = con.prepareStatement("SELECT COUNT(DISTINCT Σκηνή) FROM διάλογοι WHERE (Πράξη = ?"
                                + "OR Πράξη = ? OR Πράξη = ? OR Πράξη = ?) AND Έργο = ?");
                        countsceneResult.setString(1, selectedActs.get(0).replaceAll("ACT ", ""));
                        countsceneResult.setString(2, selectedActs.get(1).replaceAll("ACT ", ""));
                        countsceneResult.setString(3, selectedActs.get(2).replaceAll("ACT ", ""));
                        countsceneResult.setString(4, selectedActs.get(3).replaceAll("ACT ", ""));
                        countsceneResult.setInt(5, playID);
                        ResultSet countsceneRS = countsceneResult.executeQuery();
                        if (countsceneRS.next()) {
                            sceneCount = countsceneRS.getInt("COUNT(DISTINCT Σκηνή)");
                        }
                    }
                    //COUNT CHARACTERS
                    PreparedStatement countcharactersResult = con.prepareStatement("SELECT COUNT(DISTINCT Όνομα) FROM διάλογοι WHERE (Πράξη = ?"
                            + "OR Πράξη = ? OR Πράξη = ? OR Πράξη = ?) AND Έργο = ?");
                    countcharactersResult.setString(1, selectedActs.get(0).replaceAll("ACT ", ""));
                    countcharactersResult.setString(2, selectedActs.get(1).replaceAll("ACT ", ""));
                    countcharactersResult.setString(3, selectedActs.get(2).replaceAll("ACT ", ""));
                    countcharactersResult.setString(4, selectedActs.get(3).replaceAll("ACT ", ""));
                    countcharactersResult.setInt(5, playID);
                    ResultSet countcharactersRS = countcharactersResult.executeQuery();
                    if (countcharactersRS.next()) {
                        characterCount = countcharactersRS.getInt("COUNT(DISTINCT Όνομα)");
                    }
                    //COUNT DIALOGUE
                    PreparedStatement countdialogueResult = con.prepareStatement("SELECT COUNT(Διάλογος) FROM διάλογοι WHERE (Πράξη = ?"
                            + "OR Πράξη = ? OR Πράξη = ? OR Πράξη = ?) AND Έργο = ?");
                    countdialogueResult.setString(1, selectedActs.get(0).replaceAll("ACT ", ""));
                    countdialogueResult.setString(2, selectedActs.get(1).replaceAll("ACT ", ""));
                    countdialogueResult.setString(3, selectedActs.get(2).replaceAll("ACT ", ""));
                    countdialogueResult.setString(4, selectedActs.get(3).replaceAll("ACT ", ""));
                    countdialogueResult.setInt(5, playID);
                    ResultSet countdialogueRS = countdialogueResult.executeQuery();
                    if (countdialogueRS.next()) {
                        dialogueCount = countdialogueRS.getInt("COUNT(Διάλογος)");
                    }
                    if (scenesList.get(0).equals("0") == false) {
                        String statisticsMessage = "<HTML><BODY><P>Σύνολο Σκηνών: <B>" + sceneCount + "</B><BR>"
                                + "Σύνολο Χαρακτήρων: <B>" + characterCount + "</B><BR>"
                                + "Σύνολο Διαλόγων: <B>" + dialogueCount + "</B><BR></P></BODY></HTML>";
                        JOptionPane.showMessageDialog(this, statisticsMessage, "Στατιστικά", JOptionPane.INFORMATION_MESSAGE);
                    } else {
                        String statisticsMessage = "<HTML><BODY><P>Σύνολο Χαρακτήρων: <B>" + characterCount + "</B><BR>"
                                + "Σύνολο Διαλόγων: <B>" + dialogueCount + "</B><BR></P></BODY></HTML>";
                        JOptionPane.showMessageDialog(this, statisticsMessage, "Στατιστικά", JOptionPane.INFORMATION_MESSAGE);
                    }

                }

                //WORD COUNT
                if (WordCountCheckBox.isSelected()) {
                    int dialogueCounter = 0;
                    int stagedirectionsCounter = 0;
                    PreparedStatement wordCountResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες FROM διάλογοι WHERE (Πράξη = ?"
                            + "OR Πράξη = ? OR Πράξη = ? OR Πράξη = ?) AND Έργο = ?");
                    wordCountResult.setString(1, selectedActs.get(0).replaceAll("ACT ", ""));
                    wordCountResult.setString(2, selectedActs.get(1).replaceAll("ACT ", ""));
                    wordCountResult.setString(3, selectedActs.get(2).replaceAll("ACT ", ""));
                    wordCountResult.setString(4, selectedActs.get(3).replaceAll("ACT ", ""));
                    wordCountResult.setInt(5, playID);
                    ResultSet wordCountRS = wordCountResult.executeQuery();
                    while (wordCountRS.next()) {
                        dialogue.add(wordCountRS.getString("Διάλογος"));
                        stageDirections.add(wordCountRS.getString("Σκηνικές_Οδηγίες"));
                    }
                    for (int i = 0; i < dialogue.size(); i++) {
                        if (dialogue.get(i).isEmpty() == false) {
                            int count = wordCounter(dialogue.get(i));
                            dialogueCounter += count;
                        }
                    }
                    for (int i = 0; i < stageDirections.size(); i++) {
                        if (stageDirections.get(i).isEmpty() == false) {
                            int count = wordCounter(stageDirections.get(i));
                            stagedirectionsCounter += count;
                        }
                    }
                    String message2 = "<HTML><BODY><P>Αριθμός Λέξεων Διαλόγων:  <B>" + dialogueCounter + "</B><BR><BR>"
                            + "<P>Αριθμος Λέξεων Σκηνικών Οδηγιών: <B>" + stagedirectionsCounter + "</B></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, message2, "Διάλογοι και Σκηνικές Οδηγίες", JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS
                if (CrossTabsCheckBox.isSelected()) {
                    Table tabs = acts.xTabCounts("Όνομα", "Πράξη");
                    String info = "Χαρακτήρες x Πράξη Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(500, 400));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS (%)
                if (CrossPercentCheckBox.isSelected()) {
                    Table tabs = acts.xTabTablePercents("Όνομα", "Πράξη");
                    tabs.columnsOfType(ColumnType.DOUBLE).forEach(x -> ((NumberColumn) x).setPrintFormatter(NumberColumnFormatter.percent(2)));
                    String info = "Χαρακτήρες x Πράξη Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(500, 400));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }

                //PLOTS
                Table t = acts.xTabCounts("Όνομα");
                //Pie Chart
                if (PlotComboBox.getSelectedItem().equals("Πίτα")) {
                    Layout layout = Layout.builder().title("ΧΑΡΑΚΤΗΡΕΣ ΠΡΑΞΗΣ " + selectedActs.get(0).replaceAll("ACT ", "")).height(600).width(1200).build();
                    PieTrace trace = PieTrace.builder(t.column("Category"), t.numberColumn("Count")).showLegend(true).build();
                    Plot.show(new Figure(layout, trace));
                    //Bar Chart    
                } else if (PlotComboBox.getSelectedItem().equals("Ραβδόγραμμα")) {
                    Layout layout = Layout.builder().title("ΧΑΡΑΚΤΗΡΕΣ ΠΡΑΞΗΣ " + selectedActs.get(0).replaceAll("ACT ", "")).height(600).width(1200).build();
                    BarTrace trace = BarTrace.builder(t.categoricalColumn("Category"), t.numberColumn("Count")).showLegend(true).build();
                    Plot.show(new Figure(layout, trace));
                }
            }

            //ONLY SCENE SELECTION
            //ONE SCENE
            if (selectedScenes != null && selectedScenes.size() == 1 && selectedActs.isEmpty() && selectedCharacters.isEmpty()) {
                //GET CHARACTERS OF SCENE
                PreparedStatement sceneResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες, Σκηνή FROM διάλογοι WHERE Σκηνή = ?"
                        + "AND Έργο = ?");
                sceneResult.setString(1, selectedScenes.get(0).replaceAll("SCENE ", ""));
                sceneResult.setInt(2, playID);
                ResultSet sceneRS = sceneResult.executeQuery();
                //Create Table
                scenes = Table.read().db(sceneRS);
                System.out.println("Characters in " + selectedScenes.get(0) + " Table: " + scenes);

                //STATISTICS
                if (InfoCheckBox.isSelected()) {
                    int characterCount = 0;
                    int dialogueCount = 0;
                    //COUNT CHARACTERS
                    PreparedStatement countcharactersResult = con.prepareStatement("SELECT COUNT(DISTINCT Όνομα) FROM διάλογοι WHERE Σκηνή = ?"
                            + "AND Έργο = ?");
                    countcharactersResult.setString(1, selectedScenes.get(0).replaceAll("SCENE ", ""));
                    countcharactersResult.setInt(2, playID);
                    ResultSet countcharactersRS = countcharactersResult.executeQuery();
                    if (countcharactersRS.next()) {
                        characterCount = countcharactersRS.getInt("COUNT(DISTINCT Όνομα)");
                    }
                    //COUNT DIALOGUE
                    PreparedStatement countdialogueResult = con.prepareStatement("SELECT COUNT(Διάλογος) FROM διάλογοι WHERE Σκηνή = ?"
                            + "AND Έργο = ?");
                    countdialogueResult.setString(1, selectedScenes.get(0).replaceAll("SCENE ", ""));
                    countdialogueResult.setInt(2, playID);
                    ResultSet countdialogueRS = countdialogueResult.executeQuery();
                    if (countdialogueRS.next()) {
                        dialogueCount = countdialogueRS.getInt("COUNT(Διάλογος)");
                    }
                    String statisticsMessage = "<HTML><BODY><P>Σύνολο Χαρακτήρων: <B>" + characterCount + "</B><BR>"
                            + "Σύνολο Διαλόγων: <B>" + dialogueCount + "</B><BR></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, statisticsMessage, "Στατιστικά", JOptionPane.INFORMATION_MESSAGE);
                }

                //WORD COUNT
                if (WordCountCheckBox.isSelected()) {
                    int dialogueCounter = 0;
                    int stagedirectionsCounter = 0;
                    PreparedStatement wordCountResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες FROM διάλογοι WHERE Σκηνή = ?"
                            + "AND Έργο = ?");
                    wordCountResult.setString(1, selectedScenes.get(0).replaceAll("SCENE ", ""));
                    wordCountResult.setInt(2, playID);
                    ResultSet wordCountRS = wordCountResult.executeQuery();
                    while (wordCountRS.next()) {
                        dialogue.add(wordCountRS.getString("Διάλογος"));
                        stageDirections.add(wordCountRS.getString("Σκηνικές_Οδηγίες"));
                    }
                    for (int i = 0; i < dialogue.size(); i++) {
                        if (dialogue.get(i).isEmpty() == false) {
                            int count = wordCounter(dialogue.get(i));
                            dialogueCounter += count;
                        }
                    }
                    for (int i = 0; i < stageDirections.size(); i++) {
                        if (stageDirections.get(i).isEmpty() == false) {
                            int count = wordCounter(stageDirections.get(i));
                            stagedirectionsCounter += count;
                        }
                    }
                    String message2 = "<HTML><BODY><P>Αριθμός Λέξεων Διαλόγων:  <B>" + dialogueCounter + "</B><BR><BR>"
                            + "<P>Αριθμος Λέξεων Σκηνικών Οδηγιών: <B>" + stagedirectionsCounter + "</B></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, message2, "Διάλογοι και Σκηνικές Οδηγίες", JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS
                if (CrossTabsCheckBox.isSelected()) {
                    Table tabs = scenes.xTabCounts("Όνομα", "Σκηνή");
                    String info = "Χαρακτήρες x Σκηνή Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(350, 400));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS (%)
                if (CrossPercentCheckBox.isSelected()) {
                    Table tabs = scenes.xTabTablePercents("Όνομα", "Σκηνή");
                    tabs.columnsOfType(ColumnType.DOUBLE).forEach(x -> ((NumberColumn) x).setPrintFormatter(NumberColumnFormatter.percent(2)));
                    String info = "Χαρακτήρες x Σκηνή Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(350, 400));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }

                //PLOTS
                Table t = scenes.xTabCounts("Όνομα");
                //Pie Chart
                if (PlotComboBox.getSelectedItem().equals("Πίτα")) {
                    Layout layout = Layout.builder().title("ΧΑΡΑΚΤΗΡΕΣ ΣΚΗΝΗΣ " + selectedScenes.get(0).replaceAll("SCENE ", "")).height(600).width(1200).build();
                    PieTrace trace = PieTrace.builder(t.column("Category"), t.numberColumn("Count")).showLegend(true).build();
                    Plot.show(new Figure(layout, trace));
                    //Bar Chart    
                } else if (PlotComboBox.getSelectedItem().equals("Ραβδόγραμμα")) {
                    Layout layout = Layout.builder().title("ΧΑΡΑΚΤΗΡΕΣ ΣΚΗΝΗΣ " + selectedScenes.get(0).replaceAll("SCENE ", "")).height(600).width(1200).build();
                    BarTrace trace = BarTrace.builder(t.categoricalColumn("Category"), t.numberColumn("Count")).showLegend(true).build();
                    Plot.show(new Figure(layout, trace));
                }
            }
            //TWO SCENES
            if (selectedScenes != null && selectedScenes.size() == 2 && selectedActs.isEmpty() && selectedCharacters.isEmpty()) {
                //GET CHARACTERS OF SCENE
                PreparedStatement sceneResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες, Σκηνή FROM διάλογοι WHERE (Σκηνή = ?"
                        + "OR Σκηνή = ?) AND Έργο = ?");
                sceneResult.setString(1, selectedScenes.get(0).replaceAll("SCENE ", ""));
                sceneResult.setString(2, selectedScenes.get(1).replaceAll("SCENE ", ""));
                sceneResult.setInt(3, playID);
                ResultSet sceneRS = sceneResult.executeQuery();
                //Create Table
                scenes = Table.read().db(sceneRS);
                System.out.println("Characters in " + selectedScenes.get(0) + " Table: " + scenes);

                //STATISTICS
                if (InfoCheckBox.isSelected()) {
                    int characterCount = 0;
                    int dialogueCount = 0;
                    //COUNT CHARACTERS
                    PreparedStatement countcharactersResult = con.prepareStatement("SELECT COUNT(DISTINCT Όνομα) FROM διάλογοι WHERE (Σκηνή = ?"
                            + "OR Σκηνή = ?) AND Έργο = ?");
                    countcharactersResult.setString(1, selectedScenes.get(0).replaceAll("SCENE ", ""));
                    countcharactersResult.setString(2, selectedScenes.get(1).replaceAll("SCENE ", ""));
                    countcharactersResult.setInt(3, playID);
                    ResultSet countcharactersRS = countcharactersResult.executeQuery();
                    if (countcharactersRS.next()) {
                        characterCount = countcharactersRS.getInt("COUNT(DISTINCT Όνομα)");
                    }
                    //COUNT DIALOGUE
                    PreparedStatement countdialogueResult = con.prepareStatement("SELECT COUNT(Διάλογος) FROM διάλογοι WHERE (Σκηνή = ?"
                            + "OR Σκηνή = ?) AND Έργο = ?");
                    countdialogueResult.setString(1, selectedScenes.get(0).replaceAll("SCENE ", ""));
                    countdialogueResult.setString(2, selectedScenes.get(1).replaceAll("SCENE ", ""));
                    countdialogueResult.setInt(3, playID);
                    ResultSet countdialogueRS = countdialogueResult.executeQuery();
                    if (countdialogueRS.next()) {
                        dialogueCount = countdialogueRS.getInt("COUNT(Διάλογος)");
                    }
                    String statisticsMessage = "<HTML><BODY><P>Σύνολο Χαρακτήρων: <B>" + characterCount + "</B><BR>"
                            + "Σύνολο Διαλόγων: <B>" + dialogueCount + "</B><BR></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, statisticsMessage, "Στατιστικά", JOptionPane.INFORMATION_MESSAGE);
                }

                //WORD COUNT
                if (WordCountCheckBox.isSelected()) {
                    int dialogueCounter = 0;
                    int stagedirectionsCounter = 0;
                    PreparedStatement wordCountResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες FROM διάλογοι WHERE (Σκηνή = ?"
                            + "OR Σκηνή = ?) AND Έργο = ?");
                    wordCountResult.setString(1, selectedScenes.get(0).replaceAll("SCENE ", ""));
                    wordCountResult.setString(2, selectedScenes.get(1).replaceAll("SCENE ", ""));
                    wordCountResult.setInt(3, playID);
                    ResultSet wordCountRS = wordCountResult.executeQuery();
                    while (wordCountRS.next()) {
                        dialogue.add(wordCountRS.getString("Διάλογος"));
                        stageDirections.add(wordCountRS.getString("Σκηνικές_Οδηγίες"));
                    }
                    for (int i = 0; i < dialogue.size(); i++) {
                        if (dialogue.get(i).isEmpty() == false) {
                            int count = wordCounter(dialogue.get(i));
                            dialogueCounter += count;
                        }
                    }
                    for (int i = 0; i < stageDirections.size(); i++) {
                        if (stageDirections.get(i).isEmpty() == false) {
                            int count = wordCounter(stageDirections.get(i));
                            stagedirectionsCounter += count;
                        }
                    }
                    String message2 = "<HTML><BODY><P>Αριθμός Λέξεων Διαλόγων:  <B>" + dialogueCounter + "</B><BR><BR>"
                            + "<P>Αριθμος Λέξεων Σκηνικών Οδηγιών: <B>" + stagedirectionsCounter + "</B></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, message2, "Διάλογοι και Σκηνικές Οδηγίες", JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS
                if (CrossTabsCheckBox.isSelected()) {
                    Table tabs = scenes.xTabCounts("Όνομα", "Σκηνή");
                    String info = "Χαρακτήρες x Σκηνή Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(400, 400));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS (%)
                if (CrossPercentCheckBox.isSelected()) {
                    Table tabs = scenes.xTabTablePercents("Όνομα", "Σκηνή");
                    tabs.columnsOfType(ColumnType.DOUBLE).forEach(x -> ((NumberColumn) x).setPrintFormatter(NumberColumnFormatter.percent(2)));
                    String info = "Χαρακτήρες x Σκηνή Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(400, 400));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }

                //PLOTS
                Table t = scenes.xTabCounts("Όνομα");
                //Pie Chart
                if (PlotComboBox.getSelectedItem().equals("Πίτα")) {
                    Layout layout = Layout.builder().title("ΧΑΡΑΚΤΗΡΕΣ ΣΚΗΝΗΣ " + selectedScenes.get(0).replaceAll("SCENE ", "")).height(600).width(1200).build();
                    PieTrace trace = PieTrace.builder(t.column("Category"), t.numberColumn("Count")).showLegend(true).build();
                    Plot.show(new Figure(layout, trace));
                    //Bar Chart    
                } else if (PlotComboBox.getSelectedItem().equals("Ραβδόγραμμα")) {
                    Layout layout = Layout.builder().title("ΧΑΡΑΚΤΗΡΕΣ ΣΚΗΝΗΣ " + selectedScenes.get(0).replaceAll("SCENE ", "")).height(600).width(1200).build();
                    BarTrace trace = BarTrace.builder(t.categoricalColumn("Category"), t.numberColumn("Count")).showLegend(true).build();
                    Plot.show(new Figure(layout, trace));
                }
            }
            //THREE SCENES
            if (selectedScenes != null && selectedScenes.size() == 3 && selectedActs.isEmpty() && selectedCharacters.isEmpty()) {
                //GET CHARACTERS OF SCENE
                PreparedStatement sceneResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες, Σκηνή FROM διάλογοι WHERE (Σκηνή = ?"
                        + "OR Σκηνή = ? OR Σκηνή = ?) AND Έργο = ?");
                sceneResult.setString(1, selectedScenes.get(0).replaceAll("SCENE ", ""));
                sceneResult.setString(2, selectedScenes.get(1).replaceAll("SCENE ", ""));
                sceneResult.setString(3, selectedScenes.get(2).replaceAll("SCENE ", ""));
                sceneResult.setInt(4, playID);
                ResultSet sceneRS = sceneResult.executeQuery();
                //Create Table
                scenes = Table.read().db(sceneRS);
                System.out.println("Characters in " + selectedScenes.get(0) + " Table: " + scenes);

                //STATISTICS
                if (InfoCheckBox.isSelected()) {
                    int characterCount = 0;
                    int dialogueCount = 0;
                    //COUNT CHARACTERS
                    PreparedStatement countcharactersResult = con.prepareStatement("SELECT COUNT(DISTINCT Όνομα) FROM διάλογοι WHERE (Σκηνή = ?"
                            + "OR Σκηνή = ? OR Σκηνή = ?) AND Έργο = ?");
                    countcharactersResult.setString(1, selectedScenes.get(0).replaceAll("SCENE ", ""));
                    countcharactersResult.setString(2, selectedScenes.get(1).replaceAll("SCENE ", ""));
                    countcharactersResult.setString(3, selectedScenes.get(2).replaceAll("SCENE ", ""));
                    countcharactersResult.setInt(4, playID);
                    ResultSet countcharactersRS = countcharactersResult.executeQuery();
                    if (countcharactersRS.next()) {
                        characterCount = countcharactersRS.getInt("COUNT(DISTINCT Όνομα)");
                    }
                    //COUNT DIALOGUE
                    PreparedStatement countdialogueResult = con.prepareStatement("SELECT COUNT(Διάλογος) FROM διάλογοι WHERE (Σκηνή = ?"
                            + "OR Σκηνή = ? OR Σκηνή = ?) AND Έργο = ?");
                    countdialogueResult.setString(1, selectedScenes.get(0).replaceAll("SCENE ", ""));
                    countdialogueResult.setString(2, selectedScenes.get(1).replaceAll("SCENE ", ""));
                    countdialogueResult.setString(3, selectedScenes.get(2).replaceAll("SCENE ", ""));
                    countdialogueResult.setInt(4, playID);
                    ResultSet countdialogueRS = countdialogueResult.executeQuery();
                    if (countdialogueRS.next()) {
                        dialogueCount = countdialogueRS.getInt("COUNT(Διάλογος)");
                    }
                    String statisticsMessage = "<HTML><BODY><P>Σύνολο Χαρακτήρων: <B>" + characterCount + "</B><BR>"
                            + "Σύνολο Διαλόγων: <B>" + dialogueCount + "</B><BR></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, statisticsMessage, "Στατιστικά", JOptionPane.INFORMATION_MESSAGE);
                }

                //WORD COUNT
                if (WordCountCheckBox.isSelected()) {
                    int dialogueCounter = 0;
                    int stagedirectionsCounter = 0;
                    PreparedStatement wordCountResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες FROM διάλογοι WHERE (Σκηνή = ?"
                            + "OR Σκηνή = ? OR Σκηνή = ?) AND Έργο = ?");
                    wordCountResult.setString(1, selectedScenes.get(0).replaceAll("SCENE ", ""));
                    wordCountResult.setString(2, selectedScenes.get(1).replaceAll("SCENE ", ""));
                    wordCountResult.setString(3, selectedScenes.get(2).replaceAll("SCENE ", ""));
                    wordCountResult.setInt(4, playID);
                    ResultSet wordCountRS = wordCountResult.executeQuery();
                    while (wordCountRS.next()) {
                        dialogue.add(wordCountRS.getString("Διάλογος"));
                        stageDirections.add(wordCountRS.getString("Σκηνικές_Οδηγίες"));
                    }
                    for (int i = 0; i < dialogue.size(); i++) {
                        if (dialogue.get(i).isEmpty() == false) {
                            int count = wordCounter(dialogue.get(i));
                            dialogueCounter += count;
                        }
                    }
                    for (int i = 0; i < stageDirections.size(); i++) {
                        if (stageDirections.get(i).isEmpty() == false) {
                            int count = wordCounter(stageDirections.get(i));
                            stagedirectionsCounter += count;
                        }
                    }
                    String message2 = "<HTML><BODY><P>Αριθμός Λέξεων Διαλόγων:  <B>" + dialogueCounter + "</B><BR><BR>"
                            + "<P>Αριθμος Λέξεων Σκηνικών Οδηγιών: <B>" + stagedirectionsCounter + "</B></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, message2, "Διάλογοι και Σκηνικές Οδηγίες", JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS
                if (CrossTabsCheckBox.isSelected()) {
                    Table tabs = scenes.xTabCounts("Όνομα", "Σκηνή");
                    String info = "Χαρακτήρες x Σκηνή Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(400, 400));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS (%)
                if (CrossPercentCheckBox.isSelected()) {
                    Table tabs = scenes.xTabTablePercents("Όνομα", "Σκηνή");
                    tabs.columnsOfType(ColumnType.DOUBLE).forEach(x -> ((NumberColumn) x).setPrintFormatter(NumberColumnFormatter.percent(2)));
                    String info = "Χαρακτήρες x Σκηνή Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(400, 400));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }

                //PLOTS
                Table t = scenes.xTabCounts("Όνομα");
                //Pie Chart
                if (PlotComboBox.getSelectedItem().equals("Πίτα")) {
                    Layout layout = Layout.builder().title("ΧΑΡΑΚΤΗΡΕΣ ΣΚΗΝΗΣ " + selectedScenes.get(0).replaceAll("SCENE ", "")).height(600).width(1200).build();
                    PieTrace trace = PieTrace.builder(t.column("Category"), t.numberColumn("Count")).showLegend(true).build();
                    Plot.show(new Figure(layout, trace));
                    //Bar Chart    
                } else if (PlotComboBox.getSelectedItem().equals("Ραβδόγραμμα")) {
                    Layout layout = Layout.builder().title("ΧΑΡΑΚΤΗΡΕΣ ΣΚΗΝΗΣ " + selectedScenes.get(0).replaceAll("SCENE ", "")).height(600).width(1200).build();
                    BarTrace trace = BarTrace.builder(t.categoricalColumn("Category"), t.numberColumn("Count")).showLegend(true).build();
                    Plot.show(new Figure(layout, trace));
                }
            }
            //FOUR SCENES
            if (selectedScenes != null && selectedScenes.size() == 4 && selectedActs.isEmpty() && selectedCharacters.isEmpty()) {
                //GET CHARACTERS OF SCENE
                PreparedStatement sceneResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες, Σκηνή FROM διάλογοι WHERE (Σκηνή = ?"
                        + "OR Σκηνή = ? OR Σκηνή = ? OR Σκηνή = ?) AND Έργο = ?");
                sceneResult.setString(1, selectedScenes.get(0).replaceAll("SCENE ", ""));
                sceneResult.setString(2, selectedScenes.get(1).replaceAll("SCENE ", ""));
                sceneResult.setString(3, selectedScenes.get(2).replaceAll("SCENE ", ""));
                sceneResult.setString(4, selectedScenes.get(3).replaceAll("SCENE ", ""));
                sceneResult.setInt(5, playID);
                ResultSet sceneRS = sceneResult.executeQuery();
                //Create Table
                scenes = Table.read().db(sceneRS);
                System.out.println("Characters in " + selectedScenes.get(0) + " Table: " + scenes);

                //STATISTICS
                if (InfoCheckBox.isSelected()) {
                    int characterCount = 0;
                    int dialogueCount = 0;
                    //COUNT CHARACTERS
                    PreparedStatement countcharactersResult = con.prepareStatement("SELECT COUNT(DISTINCT Όνομα) FROM διάλογοι WHERE (Σκηνή = ?"
                            + "OR Σκηνή = ? OR Σκηνή = ? OR Σκηνή = ?) AND Έργο = ?");
                    countcharactersResult.setString(1, selectedScenes.get(0).replaceAll("SCENE ", ""));
                    countcharactersResult.setString(2, selectedScenes.get(1).replaceAll("SCENE ", ""));
                    countcharactersResult.setString(3, selectedScenes.get(2).replaceAll("SCENE ", ""));
                    countcharactersResult.setString(4, selectedScenes.get(3).replaceAll("SCENE ", ""));
                    countcharactersResult.setInt(5, playID);
                    ResultSet countcharactersRS = countcharactersResult.executeQuery();
                    if (countcharactersRS.next()) {
                        characterCount = countcharactersRS.getInt("COUNT(DISTINCT Όνομα)");
                    }
                    //COUNT DIALOGUE
                    PreparedStatement countdialogueResult = con.prepareStatement("SELECT COUNT(Διάλογος) FROM διάλογοι WHERE (Σκηνή = ?"
                            + "OR Σκηνή = ? OR Σκηνή = ? OR Σκηνή = ?) AND Έργο = ?");
                    countdialogueResult.setString(1, selectedScenes.get(0).replaceAll("SCENE ", ""));
                    countdialogueResult.setString(2, selectedScenes.get(1).replaceAll("SCENE ", ""));
                    countdialogueResult.setString(3, selectedScenes.get(2).replaceAll("SCENE ", ""));
                    countdialogueResult.setString(4, selectedScenes.get(3).replaceAll("SCENE ", ""));
                    countdialogueResult.setInt(5, playID);
                    ResultSet countdialogueRS = countdialogueResult.executeQuery();
                    if (countdialogueRS.next()) {
                        dialogueCount = countdialogueRS.getInt("COUNT(Διάλογος)");
                    }
                    String statisticsMessage = "<HTML><BODY><P>Σύνολο Χαρακτήρων: <B>" + characterCount + "</B><BR>"
                            + "Σύνολο Διαλόγων: <B>" + dialogueCount + "</B><BR></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, statisticsMessage, "Στατιστικά", JOptionPane.INFORMATION_MESSAGE);
                }

                //WORD COUNT
                if (WordCountCheckBox.isSelected()) {
                    int dialogueCounter = 0;
                    int stagedirectionsCounter = 0;
                    PreparedStatement wordCountResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες FROM διάλογοι WHERE (Σκηνή = ?"
                            + "OR Σκηνή = ? OR Σκηνή = ? OR Σκηνή = ?) AND Έργο = ?");
                    wordCountResult.setString(1, selectedScenes.get(0).replaceAll("SCENE ", ""));
                    wordCountResult.setString(2, selectedScenes.get(1).replaceAll("SCENE ", ""));
                    wordCountResult.setString(3, selectedScenes.get(2).replaceAll("SCENE ", ""));
                    wordCountResult.setString(4, selectedScenes.get(3).replaceAll("SCENE ", ""));
                    wordCountResult.setInt(5, playID);
                    ResultSet wordCountRS = wordCountResult.executeQuery();
                    while (wordCountRS.next()) {
                        dialogue.add(wordCountRS.getString("Διάλογος"));
                        stageDirections.add(wordCountRS.getString("Σκηνικές_Οδηγίες"));
                    }
                    for (int i = 0; i < dialogue.size(); i++) {
                        if (dialogue.get(i).isEmpty() == false) {
                            int count = wordCounter(dialogue.get(i));
                            dialogueCounter += count;
                        }
                    }
                    for (int i = 0; i < stageDirections.size(); i++) {
                        if (stageDirections.get(i).isEmpty() == false) {
                            int count = wordCounter(stageDirections.get(i));
                            stagedirectionsCounter += count;
                        }
                    }
                    String message2 = "<HTML><BODY><P>Αριθμός Λέξεων Διαλόγων:  <B>" + dialogueCounter + "</B><BR><BR>"
                            + "<P>Αριθμος Λέξεων Σκηνικών Οδηγιών: <B>" + stagedirectionsCounter + "</B></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, message2, "Διάλογοι και Σκηνικές Οδηγίες", JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS
                if (CrossTabsCheckBox.isSelected()) {
                    Table tabs = scenes.xTabCounts("Όνομα", "Σκηνή");
                    String info = "Χαρακτήρες x Σκηνή Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(500, 400));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS (%)
                if (CrossPercentCheckBox.isSelected()) {
                    Table tabs = scenes.xTabTablePercents("Όνομα", "Σκηνή");
                    tabs.columnsOfType(ColumnType.DOUBLE).forEach(x -> ((NumberColumn) x).setPrintFormatter(NumberColumnFormatter.percent(2)));
                    String info = "Χαρακτήρες x Σκηνή Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(500, 400));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }

                //PLOTS
                Table t = scenes.xTabCounts("Όνομα");
                //Pie Chart
                if (PlotComboBox.getSelectedItem().equals("Πίτα")) {
                    Layout layout = Layout.builder().title("ΧΑΡΑΚΤΗΡΕΣ ΣΚΗΝΗΣ " + selectedScenes.get(0).replaceAll("SCENE ", "")).height(600).width(1200).build();
                    PieTrace trace = PieTrace.builder(t.column("Category"), t.numberColumn("Count")).showLegend(true).build();
                    Plot.show(new Figure(layout, trace));
                    //Bar Chart    
                } else if (PlotComboBox.getSelectedItem().equals("Ραβδόγραμμα")) {
                    Layout layout = Layout.builder().title("ΧΑΡΑΚΤΗΡΕΣ ΣΚΗΝΗΣ " + selectedScenes.get(0).replaceAll("SCENE ", "")).height(600).width(1200).build();
                    BarTrace trace = BarTrace.builder(t.categoricalColumn("Category"), t.numberColumn("Count")).showLegend(true).build();
                    Plot.show(new Figure(layout, trace));
                }
            }
            //ONE SCENE WITH ONE ACT
            if (selectedScenes != null && selectedScenes.size() == 1 && selectedActs.size() == 1 && selectedCharacters.isEmpty()) {
                //GET CHARACTERS OF ACT AND SCENE
                PreparedStatement sceneResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες, Σκηνή FROM διάλογοι WHERE (Πράξη = ?"
                        + "AND Σκηνή = ?) AND Έργο = ?");
                sceneResult.setString(1, selectedActs.get(0).replaceAll("ACT ", ""));
                sceneResult.setString(2, selectedScenes.get(0).replaceAll("SCENE ", ""));
                sceneResult.setInt(3, playID);
                ResultSet sceneRS = sceneResult.executeQuery();
                if (!sceneRS.next()) {
                    //No matches found
                    String message = "<HTML><bODY><P>Δεν βρέθηκαν αποτελέσματα</P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, message, "No matches", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    //Create Table
                    scenes = Table.read().db(sceneRS);
                    System.out.println("Characters in " + selectedScenes.get(0) + " Table: " + scenes);
                }
                //STATISTICS
                if (InfoCheckBox.isSelected()) {
                    int characterCount = 0;
                    int dialogueCount = 0;
                    //COUNT CHARACTERS
                    PreparedStatement countcharactersResult = con.prepareStatement("SELECT COUNT(DISTINCT Όνομα) FROM διάλογοι WHERE (Πράξη = ?"
                            + "AND Σκηνή = ?) AND Έργο = ?");
                    countcharactersResult.setString(1, selectedActs.get(0).replaceAll("ACT ", ""));
                    countcharactersResult.setString(2, selectedScenes.get(0).replaceAll("SCENE ", ""));
                    countcharactersResult.setInt(3, playID);
                    ResultSet countcharactersRS = countcharactersResult.executeQuery();
                    if (countcharactersRS.next()) {
                        characterCount = countcharactersRS.getInt("COUNT(DISTINCT Όνομα)");
                    }
                    //COUNT DIALOGUE
                    PreparedStatement countdialogueResult = con.prepareStatement("SELECT COUNT(Διάλογος) FROM διάλογοι WHERE (Πράξη = ?"
                            + "AND Σκηνή = ?) AND Έργο = ?");
                    countdialogueResult.setString(1, selectedActs.get(0).replaceAll("ACT ", ""));
                    countdialogueResult.setString(2, selectedScenes.get(0).replaceAll("SCENE ", ""));
                    countdialogueResult.setInt(3, playID);
                    ResultSet countdialogueRS = countdialogueResult.executeQuery();
                    if (countdialogueRS.next()) {
                        dialogueCount = countdialogueRS.getInt("COUNT(Διάλογος)");
                    }
                    String statisticsMessage = "<HTML><BODY><P>Σύνολο Χαρακτήρων: <B>" + characterCount + "</B><BR>"
                            + "Σύνολο Διαλόγων: <B>" + dialogueCount + "</B><BR></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, statisticsMessage, "Στατιστικά", JOptionPane.INFORMATION_MESSAGE);
                }

                //WORD COUNT
                if (WordCountCheckBox.isSelected()) {
                    int dialogueCounter = 0;
                    int stagedirectionsCounter = 0;
                    PreparedStatement wordCountResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες FROM διάλογοι WHERE (Πράξη = ?"
                            + "AND Σκηνή = ?) AND Έργο = ?");
                    wordCountResult.setString(1, selectedActs.get(0).replaceAll("ACT ", ""));
                    wordCountResult.setString(2, selectedScenes.get(0).replaceAll("SCENE ", ""));
                    wordCountResult.setInt(3, playID);
                    ResultSet wordCountRS = wordCountResult.executeQuery();
                    while (wordCountRS.next()) {
                        dialogue.add(wordCountRS.getString("Διάλογος"));
                        stageDirections.add(wordCountRS.getString("Σκηνικές_Οδηγίες"));
                    }
                    for (int i = 0; i < dialogue.size(); i++) {
                        if (dialogue.get(i).isEmpty() == false) {
                            int count = wordCounter(dialogue.get(i));
                            dialogueCounter += count;
                        }
                    }
                    for (int i = 0; i < stageDirections.size(); i++) {
                        if (stageDirections.get(i).isEmpty() == false) {
                            int count = wordCounter(stageDirections.get(i));
                            stagedirectionsCounter += count;
                        }
                    }
                    String message2 = "<HTML><BODY><P>Αριθμός Λέξεων Διαλόγων:  <B>" + dialogueCounter + "</B><BR><BR>"
                            + "<P>Αριθμος Λέξεων Σκηνικών Οδηγιών: <B>" + stagedirectionsCounter + "</B></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, message2, "Διάλογοι και Σκηνικές Οδηγίες", JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS
                if (CrossTabsCheckBox.isSelected()) {
                    Table tabs = scenes.xTabCounts("Όνομα", "Σκηνή");
                    String info = "Χαρακτήρες x Σκηνή Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(200, 200));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS (%)
                if (CrossPercentCheckBox.isSelected()) {
                    Table tabs = scenes.xTabTablePercents("Όνομα", "Σκηνή");
                    tabs.columnsOfType(ColumnType.DOUBLE).forEach(x -> ((NumberColumn) x).setPrintFormatter(NumberColumnFormatter.percent(2)));
                    String info = "Χαρακτήρες x Σκηνή Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(200, 200));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }

                //PLOTS
                Table t = scenes.xTabCounts("Όνομα");
                //Pie Chart
                if (PlotComboBox.getSelectedItem().equals("Πίτα")) {
                    Layout layout = Layout.builder().title("ΧΑΡΑΚΤΗΡΕΣ ΣΚΗΝΗΣ " + selectedScenes.get(0).replaceAll("SCENE ", "")).height(600).width(1200).build();
                    PieTrace trace = PieTrace.builder(t.column("Category"), t.numberColumn("Count")).showLegend(true).build();
                    Plot.show(new Figure(layout, trace));
                    //Bar Chart    
                } else if (PlotComboBox.getSelectedItem().equals("Ραβδόγραμμα")) {
                    Layout layout = Layout.builder().title("ΧΑΡΑΚΤΗΡΕΣ ΣΚΗΝΗΣ " + selectedScenes.get(0).replaceAll("SCENE ", "")).height(600).width(1200).build();
                    BarTrace trace = BarTrace.builder(t.categoricalColumn("Category"), t.numberColumn("Count")).showLegend(true).build();
                    Plot.show(new Figure(layout, trace));
                }
            }
            //TWO SCENES WITH ONE ACT
            if (selectedScenes != null && selectedScenes.size() == 2 && selectedActs.size() == 1 && selectedCharacters.isEmpty()) {
                //GET CHARACTERS OF ACT AND SCENE
                PreparedStatement sceneResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες, Σκηνή FROM διάλογοι WHERE (Πράξη = ?"
                        + "AND Σκηνή = ? OR Σκηνή = ?) AND Έργο = ?");
                sceneResult.setString(1, selectedActs.get(0).replaceAll("ACT ", ""));
                sceneResult.setString(2, selectedScenes.get(0).replaceAll("SCENE ", ""));
                sceneResult.setString(3, selectedScenes.get(1).replaceAll("SCENE ", ""));
                sceneResult.setInt(4, playID);
                ResultSet sceneRS = sceneResult.executeQuery();
                if (!sceneRS.next()) {
                    //No matches found
                    String message = "<HTML><bODY><P>Δεν βρέθηκαν αποτελέσματα</P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, message, "No matches", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    //Create Table
                    scenes = Table.read().db(sceneRS);
                    System.out.println("Characters in " + selectedScenes.get(0) + " Table: " + scenes);
                }
                //STATISTICS
                if (InfoCheckBox.isSelected()) {
                    int characterCount = 0;
                    int dialogueCount = 0;
                    //COUNT CHARACTERS
                    PreparedStatement countcharactersResult = con.prepareStatement("SELECT COUNT(DISTINCT Όνομα) FROM διάλογοι WHERE (Πράξη = ?"
                            + "AND Σκηνή = ? OR Σκηνή = ?) AND Έργο = ?");
                    countcharactersResult.setString(1, selectedActs.get(0).replaceAll("ACT ", ""));
                    countcharactersResult.setString(2, selectedScenes.get(0).replaceAll("SCENE ", ""));
                    countcharactersResult.setString(3, selectedScenes.get(1).replaceAll("SCENE ", ""));
                    countcharactersResult.setInt(4, playID);
                    ResultSet countcharactersRS = countcharactersResult.executeQuery();
                    if (countcharactersRS.next()) {
                        characterCount = countcharactersRS.getInt("COUNT(DISTINCT Όνομα)");
                    }
                    //COUNT DIALOGUE
                    PreparedStatement countdialogueResult = con.prepareStatement("SELECT COUNT(Διάλογος) FROM διάλογοι WHERE (Πράξη = ?"
                            + "AND Σκηνή = ? OR Σκηνή = ?) AND Έργο = ?");
                    countdialogueResult.setString(1, selectedActs.get(0).replaceAll("ACT ", ""));
                    countdialogueResult.setString(2, selectedScenes.get(0).replaceAll("SCENE ", ""));
                    countdialogueResult.setString(3, selectedScenes.get(1).replaceAll("SCENE ", ""));
                    countdialogueResult.setInt(4, playID);
                    ResultSet countdialogueRS = countdialogueResult.executeQuery();
                    if (countdialogueRS.next()) {
                        dialogueCount = countdialogueRS.getInt("COUNT(Διάλογος)");
                    }
                    String statisticsMessage = "<HTML><BODY><P>Σύνολο Χαρακτήρων: <B>" + characterCount + "</B><BR>"
                            + "Σύνολο Διαλόγων: <B>" + dialogueCount + "</B><BR></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, statisticsMessage, "Στατιστικά", JOptionPane.INFORMATION_MESSAGE);
                }

                //WORD COUNT
                if (WordCountCheckBox.isSelected()) {
                    int dialogueCounter = 0;
                    int stagedirectionsCounter = 0;
                    PreparedStatement wordCountResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες FROM διάλογοι WHERE (Πράξη = ?"
                            + "AND Σκηνή = ? OR Σκηνή = ?) AND Έργο = ?");
                    wordCountResult.setString(1, selectedActs.get(0).replaceAll("ACT ", ""));
                    wordCountResult.setString(2, selectedScenes.get(0).replaceAll("SCENE ", ""));
                    wordCountResult.setString(3, selectedScenes.get(1).replaceAll("SCENE ", ""));
                    wordCountResult.setInt(4, playID);
                    ResultSet wordCountRS = wordCountResult.executeQuery();
                    while (wordCountRS.next()) {
                        dialogue.add(wordCountRS.getString("Διάλογος"));
                        stageDirections.add(wordCountRS.getString("Σκηνικές_Οδηγίες"));
                    }
                    for (int i = 0; i < dialogue.size(); i++) {
                        if (dialogue.get(i).isEmpty() == false) {
                            int count = wordCounter(dialogue.get(i));
                            dialogueCounter += count;
                        }
                    }
                    for (int i = 0; i < stageDirections.size(); i++) {
                        if (stageDirections.get(i).isEmpty() == false) {
                            int count = wordCounter(stageDirections.get(i));
                            stagedirectionsCounter += count;
                        }
                    }
                    String message2 = "<HTML><BODY><P>Αριθμός Λέξεων Διαλόγων:  <B>" + dialogueCounter + "</B><BR><BR>"
                            + "<P>Αριθμος Λέξεων Σκηνικών Οδηγιών: <B>" + stagedirectionsCounter + "</B></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, message2, "Διάλογοι και Σκηνικές Οδηγίες", JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS
                if (CrossTabsCheckBox.isSelected()) {
                    Table tabs = scenes.xTabCounts("Όνομα", "Σκηνή");
                    String info = "Χαρακτήρες x Σκηνή Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(500, 500));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS (%)
                if (CrossPercentCheckBox.isSelected()) {
                    Table tabs = scenes.xTabTablePercents("Όνομα", "Σκηνή");
                    tabs.columnsOfType(ColumnType.DOUBLE).forEach(x -> ((NumberColumn) x).setPrintFormatter(NumberColumnFormatter.percent(2)));
                    String info = "Χαρακτήρες x Σκηνή Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(500, 500));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }

                //PLOTS
                Table t = scenes.xTabCounts("Όνομα");
                //Pie Chart
                if (PlotComboBox.getSelectedItem().equals("Πίτα")) {
                    Layout layout = Layout.builder().title("ΧΑΡΑΚΤΗΡΕΣ ΣΚΗΝΗΣ " + selectedScenes.get(0).replaceAll("SCENE ", "")).height(600).width(1200).build();
                    PieTrace trace = PieTrace.builder(t.column("Category"), t.numberColumn("Count")).showLegend(true).build();
                    Plot.show(new Figure(layout, trace));
                    //Bar Chart    
                } else if (PlotComboBox.getSelectedItem().equals("Ραβδόγραμμα")) {
                    Layout layout = Layout.builder().title("ΧΑΡΑΚΤΗΡΕΣ ΣΚΗΝΗΣ " + selectedScenes.get(0).replaceAll("SCENE ", "")).height(600).width(1200).build();
                    BarTrace trace = BarTrace.builder(t.categoricalColumn("Category"), t.numberColumn("Count")).showLegend(true).build();
                    Plot.show(new Figure(layout, trace));
                }
            }
            //TWO SCENES WITH TWO ACTS
            if (selectedScenes != null && selectedScenes.size() == 2 && selectedActs.size() == 2 && selectedCharacters.isEmpty()) {
                //GET CHARACTERS OF ACT AND SCENE
                PreparedStatement sceneResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες, Σκηνή FROM διάλογοι WHERE (Πράξη = ?"
                        + "OR Πράξη = ? AND Σκηνή = ? OR Σκηνή = ?) AND Έργο = ?");
                sceneResult.setString(1, selectedActs.get(0).replaceAll("ACT ", ""));
                sceneResult.setString(2, selectedActs.get(1).replaceAll("ACT ", ""));
                sceneResult.setString(3, selectedScenes.get(0).replaceAll("SCENE ", ""));
                sceneResult.setString(4, selectedScenes.get(1).replaceAll("SCENE ", ""));
                sceneResult.setInt(5, playID);
                ResultSet sceneRS = sceneResult.executeQuery();
                if (!sceneRS.next()) {
                    //No matches found
                    String message = "<HTML><bODY><P>Δεν βρέθηκαν αποτελέσματα</P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, message, "No matches", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    //Create Table
                    scenes = Table.read().db(sceneRS);
                    System.out.println("Characters in " + selectedScenes.get(0) + " Table: " + scenes);
                }
                //STATISTICS
                if (InfoCheckBox.isSelected()) {
                    int characterCount = 0;
                    int dialogueCount = 0;
                    //COUNT CHARACTERS
                    PreparedStatement countcharactersResult = con.prepareStatement("SELECT COUNT(DISTINCT Όνομα) FROM διάλογοι WHERE (Πράξη = ?"
                            + "OR Πράξη = ? AND Σκηνή = ? OR Σκηνή = ?) AND Έργο = ?");
                    countcharactersResult.setString(1, selectedActs.get(0).replaceAll("ACT ", ""));
                    countcharactersResult.setString(2, selectedActs.get(1).replaceAll("ACT ", ""));
                    countcharactersResult.setString(3, selectedScenes.get(0).replaceAll("SCENE ", ""));
                    countcharactersResult.setString(4, selectedScenes.get(1).replaceAll("SCENE ", ""));
                    countcharactersResult.setInt(5, playID);
                    ResultSet countcharactersRS = countcharactersResult.executeQuery();
                    if (countcharactersRS.next()) {
                        characterCount = countcharactersRS.getInt("COUNT(DISTINCT Όνομα)");
                    }
                    //COUNT DIALOGUE
                    PreparedStatement countdialogueResult = con.prepareStatement("SELECT COUNT(Διάλογος) FROM διάλογοι WHERE (Πράξη = ?"
                            + "OR Πράξη = ? AND Σκηνή = ? OR Σκηνή = ?) AND Έργο = ?");
                    countdialogueResult.setString(1, selectedActs.get(0).replaceAll("ACT ", ""));
                    countdialogueResult.setString(2, selectedActs.get(1).replaceAll("ACT ", ""));
                    countdialogueResult.setString(3, selectedScenes.get(0).replaceAll("SCENE ", ""));
                    countdialogueResult.setString(4, selectedScenes.get(1).replaceAll("SCENE ", ""));
                    countdialogueResult.setInt(5, playID);
                    ResultSet countdialogueRS = countdialogueResult.executeQuery();
                    if (countdialogueRS.next()) {
                        dialogueCount = countdialogueRS.getInt("COUNT(Διάλογος)");
                    }
                    String statisticsMessage = "<HTML><BODY><P>Σύνολο Χαρακτήρων: <B>" + characterCount + "</B><BR>"
                            + "Σύνολο Διαλόγων: <B>" + dialogueCount + "</B><BR></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, statisticsMessage, "Στατιστικά", JOptionPane.INFORMATION_MESSAGE);
                }

                //WORD COUNT
                if (WordCountCheckBox.isSelected()) {
                    int dialogueCounter = 0;
                    int stagedirectionsCounter = 0;
                    PreparedStatement wordCountResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες FROM διάλογοι WHERE (Πράξη = ?"
                            + "OR Πράξη = ? AND Σκηνή = ? OR Σκηνή = ?) AND Έργο = ?");
                    wordCountResult.setString(1, selectedActs.get(0).replaceAll("ACT ", ""));
                    wordCountResult.setString(2, selectedActs.get(1).replaceAll("ACT ", ""));
                    wordCountResult.setString(3, selectedScenes.get(0).replaceAll("SCENE ", ""));
                    wordCountResult.setString(4, selectedScenes.get(1).replaceAll("SCENE ", ""));
                    wordCountResult.setInt(5, playID);
                    ResultSet wordCountRS = wordCountResult.executeQuery();
                    while (wordCountRS.next()) {
                        dialogue.add(wordCountRS.getString("Διάλογος"));
                        stageDirections.add(wordCountRS.getString("Σκηνικές_Οδηγίες"));
                    }
                    for (int i = 0; i < dialogue.size(); i++) {
                        if (dialogue.get(i).isEmpty() == false) {
                            int count = wordCounter(dialogue.get(i));
                            dialogueCounter += count;
                        }
                    }
                    for (int i = 0; i < stageDirections.size(); i++) {
                        if (stageDirections.get(i).isEmpty() == false) {
                            int count = wordCounter(stageDirections.get(i));
                            stagedirectionsCounter += count;
                        }
                    }
                    String message2 = "<HTML><BODY><P>Αριθμός Λέξεων Διαλόγων:  <B>" + dialogueCounter + "</B><BR><BR>"
                            + "<P>Αριθμος Λέξεων Σκηνικών Οδηγιών: <B>" + stagedirectionsCounter + "</B></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, message2, "Διάλογοι και Σκηνικές Οδηγίες", JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS
                if (CrossTabsCheckBox.isSelected()) {
                    Table tabs = scenes.xTabCounts("Όνομα", "Σκηνή");
                    String info = "Χαρακτήρες x Σκηνή Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(500, 500));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS (%)
                if (CrossPercentCheckBox.isSelected()) {
                    Table tabs = scenes.xTabTablePercents("Όνομα", "Σκηνή");
                    tabs.columnsOfType(ColumnType.DOUBLE).forEach(x -> ((NumberColumn) x).setPrintFormatter(NumberColumnFormatter.percent(2)));
                    String info = "Χαρακτήρες x Σκηνή Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(500, 500));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }

                //PLOTS
                Table t = scenes.xTabCounts("Όνομα");
                //Pie Chart
                if (PlotComboBox.getSelectedItem().equals("Πίτα")) {
                    Layout layout = Layout.builder().title("ΧΑΡΑΚΤΗΡΕΣ ΣΚΗΝΗΣ " + selectedScenes.get(0).replaceAll("SCENE ", "")).height(600).width(1200).build();
                    PieTrace trace = PieTrace.builder(t.column("Category"), t.numberColumn("Count")).showLegend(true).build();
                    Plot.show(new Figure(layout, trace));
                    //Bar Chart    
                } else if (PlotComboBox.getSelectedItem().equals("Ραβδόγραμμα")) {
                    Layout layout = Layout.builder().title("ΧΑΡΑΚΤΗΡΕΣ ΣΚΗΝΗΣ " + selectedScenes.get(0).replaceAll("SCENE ", "")).height(600).width(1200).build();
                    BarTrace trace = BarTrace.builder(t.categoricalColumn("Category"), t.numberColumn("Count")).showLegend(true).build();
                    Plot.show(new Figure(layout, trace));
                }
            }

            //CHARACTER SELECTION
            if (selectedCharacters != null && selectedCharacters.size() == 1 && selectedActs.isEmpty() && selectedScenes.isEmpty()) {
                //Get Character of Play
                PreparedStatement characterResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες FROM διάλογοι WHERE Όνομα = ? AND Έργο = ?");
                characterResult.setString(1, selectedCharacters.get(0));
                characterResult.setInt(2, playID);
                ResultSet characterRS = characterResult.executeQuery();
                //Create Table
                characters = Table.read().db(characterRS);
                System.out.println("Character Table: " + characters);

                //STATISTICS
                if (InfoCheckBox.isSelected()) {
                    int dialogueCount = 0;
                    //COUNT DIALOGUE
                    PreparedStatement countdialogueResult = con.prepareStatement("SELECT COUNT(Διάλογος) FROM διάλογοι WHERE Όνομα = ? AND Έργο = ?");
                    countdialogueResult.setString(1, selectedCharacters.get(0));
                    countdialogueResult.setInt(2, playID);
                    ResultSet countdialogueRS = countdialogueResult.executeQuery();
                    if (countdialogueRS.next()) {
                        dialogueCount = countdialogueRS.getInt("COUNT(Διάλογος)");
                    }
                    String statisticsMessage = "<HTML><BODY><P>Σύνολο Διαλόγων: <B>" + dialogueCount + "</B><BR></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, statisticsMessage, "Στατιστικά", JOptionPane.INFORMATION_MESSAGE);
                }
                //WORD COUNT
                if (WordCountCheckBox.isSelected()) {
                    int dialogueCounter = 0;
                    int stagedirectionsCounter = 0;
                    PreparedStatement wordCountResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες FROM διάλογοι WHERE Όνομα = ?"
                            + "AND Έργο = ?");
                    wordCountResult.setString(1, selectedCharacters.get(0));
                    wordCountResult.setInt(2, playID);
                    ResultSet wordCountRS = wordCountResult.executeQuery();
                    while (wordCountRS.next()) {
                        dialogue.add(wordCountRS.getString("Διάλογος"));
                        stageDirections.add(wordCountRS.getString("Σκηνικές_Οδηγίες"));
                    }
                    for (int i = 0; i < dialogue.size(); i++) {
                        if (dialogue.get(i).isEmpty() == false) {
                            int count = wordCounter(dialogue.get(i));
                            dialogueCounter += count;
                        }
                    }
                    for (int i = 0; i < stageDirections.size(); i++) {
                        if (stageDirections.get(i).isEmpty() == false) {
                            int count = wordCounter(stageDirections.get(i));
                            stagedirectionsCounter += count;
                        }
                    }
                    String message2 = "<HTML><BODY><P>Αριθμός Λέξεων Διαλόγων:  <B>" + dialogueCounter + "</B><BR><BR>"
                            + "<P>Αριθμος Λέξεων Σκηνικών Οδηγιών: <B>" + stagedirectionsCounter + "</B></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, message2, "Διάλογοι και Σκηνικές Οδηγίες", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            //1 CHARACTER IN 1 ACT
            if (selectedCharacters != null && selectedCharacters.size() == 1 && selectedActs.size() == 1 && selectedScenes.isEmpty()) {
                //Get Characters of Play based on Act
                PreparedStatement actResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες, Πράξη FROM διάλογοι WHERE Όνομα = ?"
                        + "AND Πράξη = ? AND Έργο = ?");
                actResult.setString(1, selectedCharacters.get(0));
                actResult.setInt(2, Integer.parseInt(selectedActs.get(0).replaceAll("ACT ", "")));
                actResult.setInt(3, playID);
                ResultSet actRS = actResult.executeQuery();
                if (!actRS.next()) {
                    //No matches found
                    String message = "<HTML><bODY><P>Δεν βρέθηκαν αποτελέσματα</P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, message, "No matches", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    //Create Table
                    charactersinAct = Table.read().db(actRS);
                    System.out.println("Characters in " + selectedActs.get(0) + " Table: " + charactersinAct);
                }

                //STATISTICS
                if (InfoCheckBox.isSelected()) {
                    int dialogueCount = 0;
                    //COUNT DIALOGUE
                    PreparedStatement countdialogueResult = con.prepareStatement("SELECT COUNT(Διάλογος) FROM διάλογοι WHERE Όνομα = ? "
                            + "AND Πράξη = ? AND Έργο = ?");
                    countdialogueResult.setString(1, selectedCharacters.get(0));
                    countdialogueResult.setInt(2, Integer.parseInt(selectedActs.get(0).replaceAll("ACT ", "")));
                    countdialogueResult.setInt(3, playID);
                    ResultSet countdialogueRS = countdialogueResult.executeQuery();
                    if (countdialogueRS.next()) {
                        dialogueCount = countdialogueRS.getInt("COUNT(Διάλογος)");
                    }
                    String statisticsMessage = "<HTML><BODY><P>Σύνολο Διαλόγων: <B>" + dialogueCount + "</B><BR></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, statisticsMessage, "Στατιστικά", JOptionPane.INFORMATION_MESSAGE);
                }
                //WORD COUNT
                if (WordCountCheckBox.isSelected()) {
                    int dialogueCounter = 0;
                    int stagedirectionsCounter = 0;
                    PreparedStatement wordCountResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες FROM διάλογοι WHERE Όνομα = ?"
                            + "AND Πράξη = ? AND Έργο = ?");
                    wordCountResult.setString(1, selectedCharacters.get(0));
                    wordCountResult.setInt(2, Integer.parseInt(selectedActs.get(0).replaceAll("ACT ", "")));
                    wordCountResult.setInt(3, playID);
                    ResultSet wordCountRS = wordCountResult.executeQuery();
                    while (wordCountRS.next()) {
                        dialogue.add(wordCountRS.getString("Διάλογος"));
                        stageDirections.add(wordCountRS.getString("Σκηνικές_Οδηγίες"));
                    }
                    for (int i = 0; i < dialogue.size(); i++) {
                        if (dialogue.get(i).isEmpty() == false) {
                            int count = wordCounter(dialogue.get(i));
                            dialogueCounter += count;
                        }
                    }
                    for (int i = 0; i < stageDirections.size(); i++) {
                        if (stageDirections.get(i).isEmpty() == false) {
                            int count = wordCounter(stageDirections.get(i));
                            stagedirectionsCounter += count;
                        }
                    }
                    String message2 = "<HTML><BODY><P>Αριθμός Λέξεων Διαλόγων:  <B>" + dialogueCounter + "</B><BR><BR>"
                            + "<P>Αριθμος Λέξεων Σκηνικών Οδηγιών: <B>" + stagedirectionsCounter + "</B></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, message2, "Διάλογοι και Σκηνικές Οδηγίες", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            //1 CHARACTER IN 2 ACTS 
            if (selectedCharacters != null && selectedCharacters.size() == 1 && selectedActs.size() == 2 && selectedScenes.isEmpty()) {
                //Get Characters of Play based on Acts
                PreparedStatement actResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες, Πράξη FROM διάλογοι WHERE Όνομα = ?"
                        + "AND (Πράξη = ? OR Πράξη = ?) AND Έργο = ?");
                actResult.setString(1, selectedCharacters.get(0));
                actResult.setInt(2, Integer.parseInt(selectedActs.get(0).replaceAll("ACT ", "")));
                actResult.setInt(3, Integer.parseInt(selectedActs.get(1).replaceAll("ACT ", "")));
                actResult.setInt(4, playID);
                ResultSet actRS = actResult.executeQuery();
                if (!actRS.next()) {
                    //No matches found
                    String message = "<HTML><bODY><P>Δεν βρέθηκαν αποτελέσματα</P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, message, "No matches", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    //Create Table
                    charactersinAct = Table.read().db(actRS);
                    System.out.println("Characters in " + selectedActs.get(0) + " Table: " + charactersinAct);
                }

                //STATISTICS
                if (InfoCheckBox.isSelected()) {
                    int dialogueCount = 0;
                    //COUNT DIALOGUE
                    PreparedStatement countdialogueResult = con.prepareStatement("SELECT COUNT(Διάλογος) FROM διάλογοι WHERE Όνομα = ? "
                            + "AND (Πράξη = ? OR Πράξη = ?) AND Έργο = ?");
                    countdialogueResult.setString(1, selectedCharacters.get(0));
                    countdialogueResult.setInt(2, Integer.parseInt(selectedActs.get(0).replaceAll("ACT ", "")));
                    countdialogueResult.setInt(3, Integer.parseInt(selectedActs.get(1).replaceAll("ACT ", "")));
                    countdialogueResult.setInt(4, playID);
                    ResultSet countdialogueRS = countdialogueResult.executeQuery();
                    if (countdialogueRS.next()) {
                        dialogueCount = countdialogueRS.getInt("COUNT(Διάλογος)");
                    }
                    String statisticsMessage = "<HTML><BODY><P>Σύνολο Διαλόγων: <B>" + dialogueCount + "</B><BR></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, statisticsMessage, "Στατιστικά", JOptionPane.INFORMATION_MESSAGE);
                }
                //WORD COUNT
                if (WordCountCheckBox.isSelected()) {
                    int dialogueCounter = 0;
                    int stagedirectionsCounter = 0;
                    PreparedStatement wordCountResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες FROM διάλογοι WHERE Όνομα = ?"
                            + "AND (Πράξη = ? OR Πράξη = ?) AND Έργο = ?");
                    wordCountResult.setString(1, selectedCharacters.get(0));
                    wordCountResult.setInt(2, Integer.parseInt(selectedActs.get(0).replaceAll("ACT ", "")));
                    wordCountResult.setInt(3, Integer.parseInt(selectedActs.get(1).replaceAll("ACT ", "")));
                    wordCountResult.setInt(4, playID);
                    ResultSet wordCountRS = wordCountResult.executeQuery();
                    while (wordCountRS.next()) {
                        dialogue.add(wordCountRS.getString("Διάλογος"));
                        stageDirections.add(wordCountRS.getString("Σκηνικές_Οδηγίες"));
                    }
                    for (int i = 0; i < dialogue.size(); i++) {
                        if (dialogue.get(i).isEmpty() == false) {
                            int count = wordCounter(dialogue.get(i));
                            dialogueCounter += count;
                        }
                    }
                    for (int i = 0; i < stageDirections.size(); i++) {
                        if (stageDirections.get(i).isEmpty() == false) {
                            int count = wordCounter(stageDirections.get(i));
                            stagedirectionsCounter += count;
                        }
                    }
                    String message2 = "<HTML><BODY><P>Αριθμός Λέξεων Διαλόγων:  <B>" + dialogueCounter + "</B><BR><BR>"
                            + "<P>Αριθμος Λέξεων Σκηνικών Οδηγιών: <B>" + stagedirectionsCounter + "</B></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, message2, "Διάλογοι και Σκηνικές Οδηγίες", JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS
                if (CrossTabsCheckBox.isSelected()) {
                    Table tabs = charactersinAct.xTabCounts("Όνομα", "Πράξη");
                    String info = "Χαρακτήρας x Πράξεις Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(300, 300));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS (%)
                if (CrossPercentCheckBox.isSelected()) {
                    Table tabs = charactersinAct.xTabTablePercents("Όνομα", "Πράξη");
                    tabs.columnsOfType(ColumnType.DOUBLE).forEach(x -> ((NumberColumn) x).setPrintFormatter(NumberColumnFormatter.percent(2)));
                    String info = "Χαρακτήρας x Πράξεις Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(300, 300));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }
            }
            //1 CHARACTER IN 3 ACTS 
            if (selectedCharacters != null && selectedCharacters.size() == 1 && selectedActs.size() == 3 && selectedScenes.isEmpty()) {
                //Get Characters of Play based on Acts
                PreparedStatement actResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες, Πράξη FROM διάλογοι WHERE Όνομα = ?"
                        + "AND (Πράξη = ? OR Πράξη = ? OR Πράξη = ?) AND Έργο = ?");
                actResult.setString(1, selectedCharacters.get(0));
                actResult.setInt(2, Integer.parseInt(selectedActs.get(0).replaceAll("ACT ", "")));
                actResult.setInt(3, Integer.parseInt(selectedActs.get(1).replaceAll("ACT ", "")));
                actResult.setInt(4, Integer.parseInt(selectedActs.get(2).replaceAll("ACT ", "")));
                actResult.setInt(5, playID);
                ResultSet actRS = actResult.executeQuery();
                if (!actRS.next()) {
                    //No matches found
                    String message = "<HTML><bODY><P>Δεν βρέθηκαν αποτελέσματα</P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, message, "No matches", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    //Create Table
                    charactersinAct = Table.read().db(actRS);
                    System.out.println("Characters in " + selectedActs.get(0) + " Table: " + charactersinAct);
                }

                //STATISTICS
                if (InfoCheckBox.isSelected()) {
                    int dialogueCount = 0;
                    //COUNT DIALOGUE
                    PreparedStatement countdialogueResult = con.prepareStatement("SELECT COUNT(Διάλογος) FROM διάλογοι WHERE Όνομα = ? "
                            + "AND (Πράξη = ? OR Πράξη = ? OR Πράξη = ?) AND Έργο = ?");
                    countdialogueResult.setString(1, selectedCharacters.get(0));
                    countdialogueResult.setInt(2, Integer.parseInt(selectedActs.get(0).replaceAll("ACT ", "")));
                    countdialogueResult.setInt(3, Integer.parseInt(selectedActs.get(1).replaceAll("ACT ", "")));
                    countdialogueResult.setInt(4, Integer.parseInt(selectedActs.get(2).replaceAll("ACT ", "")));
                    countdialogueResult.setInt(5, playID);
                    ResultSet countdialogueRS = countdialogueResult.executeQuery();
                    if (countdialogueRS.next()) {
                        dialogueCount = countdialogueRS.getInt("COUNT(Διάλογος)");
                    }
                    String statisticsMessage = "<HTML><BODY><P>Σύνολο Διαλόγων: <B>" + dialogueCount + "</B><BR></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, statisticsMessage, "Στατιστικά", JOptionPane.INFORMATION_MESSAGE);
                }
                //WORD COUNT
                if (WordCountCheckBox.isSelected()) {
                    int dialogueCounter = 0;
                    int stagedirectionsCounter = 0;
                    PreparedStatement wordCountResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες FROM διάλογοι WHERE Όνομα = ?"
                            + "AND (Πράξη = ? OR Πράξη = ? OR Πράξη = ?) AND Έργο = ?");
                    wordCountResult.setString(1, selectedCharacters.get(0));
                    wordCountResult.setInt(2, Integer.parseInt(selectedActs.get(0).replaceAll("ACT ", "")));
                    wordCountResult.setInt(3, Integer.parseInt(selectedActs.get(1).replaceAll("ACT ", "")));
                    wordCountResult.setInt(4, Integer.parseInt(selectedActs.get(2).replaceAll("ACT ", "")));
                    wordCountResult.setInt(5, playID);
                    ResultSet wordCountRS = wordCountResult.executeQuery();
                    while (wordCountRS.next()) {
                        dialogue.add(wordCountRS.getString("Διάλογος"));
                        stageDirections.add(wordCountRS.getString("Σκηνικές_Οδηγίες"));
                    }
                    for (int i = 0; i < dialogue.size(); i++) {
                        if (dialogue.get(i).isEmpty() == false) {
                            int count = wordCounter(dialogue.get(i));
                            dialogueCounter += count;
                        }
                    }
                    for (int i = 0; i < stageDirections.size(); i++) {
                        if (stageDirections.get(i).isEmpty() == false) {
                            int count = wordCounter(stageDirections.get(i));
                            stagedirectionsCounter += count;
                        }
                    }
                    String message2 = "<HTML><BODY><P>Αριθμός Λέξεων Διαλόγων:  <B>" + dialogueCounter + "</B><BR><BR>"
                            + "<P>Αριθμος Λέξεων Σκηνικών Οδηγιών: <B>" + stagedirectionsCounter + "</B></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, message2, "Διάλογοι και Σκηνικές Οδηγίες", JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS
                if (CrossTabsCheckBox.isSelected()) {
                    Table tabs = charactersinAct.xTabCounts("Όνομα", "Πράξη");
                    String info = "Χαρακτήρας x Πράξεις Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(400, 300));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS (%)
                if (CrossPercentCheckBox.isSelected()) {
                    Table tabs = charactersinAct.xTabTablePercents("Όνομα", "Πράξη");
                    tabs.columnsOfType(ColumnType.DOUBLE).forEach(x -> ((NumberColumn) x).setPrintFormatter(NumberColumnFormatter.percent(2)));
                    String info = "Χαρακτήρας x Πράξεις Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(400, 300));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }
            }
            //1 CHARACTER IN 1 SCENE
            if (selectedCharacters != null && selectedCharacters.size() == 1 && selectedScenes.size() == 1 && selectedActs.isEmpty()) {
                //Get Characters of Play based on Acts
                PreparedStatement sceneResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες, Πράξη FROM διάλογοι WHERE Όνομα = ?"
                        + "AND Σκηνή = ? AND Έργο = ?");
                sceneResult.setString(1, selectedCharacters.get(0));
                sceneResult.setInt(2, Integer.parseInt(selectedScenes.get(0).replaceAll("SCENE ", "")));
                sceneResult.setInt(3, playID);
                ResultSet sceneRS = sceneResult.executeQuery();
                if (!sceneRS.next()) {
                    //No matches found
                    String message = "<HTML><bODY><P>Δεν βρέθηκαν αποτελέσματα</P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, message, "No matches", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    //Create Table
                    charactersinScene = Table.read().db(sceneRS);
                    System.out.println("Characters in " + selectedScenes.get(0) + " Table: " + charactersinScene);
                }

                //STATISTICS
                if (InfoCheckBox.isSelected()) {
                    int dialogueCount = 0;
                    //COUNT DIALOGUE
                    PreparedStatement countdialogueResult = con.prepareStatement("SELECT COUNT(Διάλογος) FROM διάλογοι WHERE Όνομα = ? "
                            + "AND Σκηνή = ? AND Έργο = ?");
                    countdialogueResult.setString(1, selectedCharacters.get(0));
                    countdialogueResult.setInt(2, Integer.parseInt(selectedScenes.get(0).replaceAll("SCENE ", "")));
                    countdialogueResult.setInt(3, playID);
                    ResultSet countdialogueRS = countdialogueResult.executeQuery();
                    if (countdialogueRS.next()) {
                        dialogueCount = countdialogueRS.getInt("COUNT(Διάλογος)");
                    }
                    String statisticsMessage = "<HTML><BODY><P>Σύνολο Διαλόγων: <B>" + dialogueCount + "</B><BR></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, statisticsMessage, "Στατιστικά", JOptionPane.INFORMATION_MESSAGE);
                }
                //WORD COUNT
                if (WordCountCheckBox.isSelected()) {
                    int dialogueCounter = 0;
                    int stagedirectionsCounter = 0;
                    PreparedStatement wordCountResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες FROM διάλογοι WHERE Όνομα = ?"
                            + "AND Σκηνή = ? AND Έργο = ?");
                    wordCountResult.setString(1, selectedCharacters.get(0));
                    wordCountResult.setInt(2, Integer.parseInt(selectedScenes.get(0).replaceAll("SCENE ", "")));
                    wordCountResult.setInt(3, playID);
                    ResultSet wordCountRS = wordCountResult.executeQuery();
                    while (wordCountRS.next()) {
                        dialogue.add(wordCountRS.getString("Διάλογος"));
                        stageDirections.add(wordCountRS.getString("Σκηνικές_Οδηγίες"));
                    }
                    for (int i = 0; i < dialogue.size(); i++) {
                        if (dialogue.get(i).isEmpty() == false) {
                            int count = wordCounter(dialogue.get(i));
                            dialogueCounter += count;
                        }
                    }
                    for (int i = 0; i < stageDirections.size(); i++) {
                        if (stageDirections.get(i).isEmpty() == false) {
                            int count = wordCounter(stageDirections.get(i));
                            stagedirectionsCounter += count;
                        }
                    }
                    String message2 = "<HTML><BODY><P>Αριθμός Λέξεων Διαλόγων:  <B>" + dialogueCounter + "</B><BR><BR>"
                            + "<P>Αριθμος Λέξεων Σκηνικών Οδηγιών: <B>" + stagedirectionsCounter + "</B></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, message2, "Διάλογοι και Σκηνικές Οδηγίες", JOptionPane.INFORMATION_MESSAGE);
                }
            }
            //1 CHARACTER IN 2 SCENES
            if (selectedCharacters != null && selectedCharacters.size() == 1 && selectedScenes.size() == 2 && selectedActs.isEmpty()) {
                //Get Characters of Play based on Acts
                PreparedStatement sceneResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες, Σκηνή FROM διάλογοι WHERE Όνομα = ?"
                        + "AND (Σκηνή = ? OR Σκηνή = ?) AND Έργο = ?");
                sceneResult.setString(1, selectedCharacters.get(0));
                sceneResult.setInt(2, Integer.parseInt(selectedScenes.get(0).replaceAll("SCENE ", "")));
                sceneResult.setInt(3, Integer.parseInt(selectedScenes.get(1).replaceAll("SCENE ", "")));
                sceneResult.setInt(4, playID);
                ResultSet sceneRS = sceneResult.executeQuery();
                if (!sceneRS.next()) {
                    //No matches found
                    String message = "<HTML><bODY><P>Δεν βρέθηκαν αποτελέσματα</P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, message, "No matches", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    //Create Table
                    charactersinScene = Table.read().db(sceneRS);
                    System.out.println("Characters in " + selectedScenes.get(0) + " Table: " + charactersinScene);
                }

                //STATISTICS
                if (InfoCheckBox.isSelected()) {
                    int dialogueCount = 0;
                    //COUNT DIALOGUE
                    PreparedStatement countdialogueResult = con.prepareStatement("SELECT COUNT(Διάλογος) FROM διάλογοι WHERE Όνομα = ? "
                            + "AND (Σκηνή = ? OR Σκηνή = ?) AND Έργο = ?");
                    countdialogueResult.setString(1, selectedCharacters.get(0));
                    countdialogueResult.setInt(2, Integer.parseInt(selectedScenes.get(0).replaceAll("SCENE ", "")));
                    countdialogueResult.setInt(3, Integer.parseInt(selectedScenes.get(1).replaceAll("SCENE ", "")));
                    countdialogueResult.setInt(4, playID);
                    ResultSet countdialogueRS = countdialogueResult.executeQuery();
                    if (countdialogueRS.next()) {
                        dialogueCount = countdialogueRS.getInt("COUNT(Διάλογος)");
                    }
                    String statisticsMessage = "<HTML><BODY><P>Σύνολο Διαλόγων: <B>" + dialogueCount + "</B><BR></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, statisticsMessage, "Στατιστικά", JOptionPane.INFORMATION_MESSAGE);
                }
                //WORD COUNT
                if (WordCountCheckBox.isSelected()) {
                    int dialogueCounter = 0;
                    int stagedirectionsCounter = 0;
                    PreparedStatement wordCountResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες FROM διάλογοι WHERE Όνομα = ?"
                            + "AND (Σκηνή = ? OR Σκηνή = ?) AND Έργο = ?");
                    wordCountResult.setString(1, selectedCharacters.get(0));
                    wordCountResult.setInt(2, Integer.parseInt(selectedScenes.get(0).replaceAll("SCENE ", "")));
                    wordCountResult.setInt(3, Integer.parseInt(selectedScenes.get(1).replaceAll("SCENE ", "")));
                    wordCountResult.setInt(4, playID);
                    ResultSet wordCountRS = wordCountResult.executeQuery();
                    while (wordCountRS.next()) {
                        dialogue.add(wordCountRS.getString("Διάλογος"));
                        stageDirections.add(wordCountRS.getString("Σκηνικές_Οδηγίες"));
                    }
                    for (int i = 0; i < dialogue.size(); i++) {
                        if (dialogue.get(i).isEmpty() == false) {
                            int count = wordCounter(dialogue.get(i));
                            dialogueCounter += count;
                        }
                    }
                    for (int i = 0; i < stageDirections.size(); i++) {
                        if (stageDirections.get(i).isEmpty() == false) {
                            int count = wordCounter(stageDirections.get(i));
                            stagedirectionsCounter += count;
                        }
                    }
                    String message2 = "<HTML><BODY><P>Αριθμός Λέξεων Διαλόγων:  <B>" + dialogueCounter + "</B><BR><BR>"
                            + "<P>Αριθμος Λέξεων Σκηνικών Οδηγιών: <B>" + stagedirectionsCounter + "</B></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, message2, "Διάλογοι και Σκηνικές Οδηγίες", JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS
                if (CrossTabsCheckBox.isSelected()) {
                    Table tabs = charactersinScene.xTabCounts("Όνομα", "Σκηνή");
                    String info = "Χαρακτήρας x Σκηνές Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(300, 300));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS (%)
                if (CrossPercentCheckBox.isSelected()) {
                    Table tabs = charactersinScene.xTabTablePercents("Όνομα", "Σκηνή");
                    tabs.columnsOfType(ColumnType.DOUBLE).forEach(x -> ((NumberColumn) x).setPrintFormatter(NumberColumnFormatter.percent(2)));
                    String info = "Χαρακτήρας x Σκηνές Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(300, 300));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }
            }
            //1 CHARACTER IN 3 SCENES
            if (selectedCharacters != null && selectedCharacters.size() == 1 && selectedScenes.size() == 3 && selectedActs.isEmpty()) {
                //Get Characters of Play based on Acts
                PreparedStatement sceneResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες, Σκηνή FROM διάλογοι WHERE Όνομα = ?"
                        + "AND (Σκηνή = ? OR Σκηνή = ? OR Σκηνή = ?) AND Έργο = ?");
                sceneResult.setString(1, selectedCharacters.get(0));
                sceneResult.setInt(2, Integer.parseInt(selectedScenes.get(0).replaceAll("SCENE ", "")));
                sceneResult.setInt(3, Integer.parseInt(selectedScenes.get(1).replaceAll("SCENE ", "")));
                sceneResult.setInt(4, Integer.parseInt(selectedScenes.get(2).replaceAll("SCENE ", "")));
                sceneResult.setInt(5, playID);
                ResultSet sceneRS = sceneResult.executeQuery();
                if (!sceneRS.next()) {
                    //No matches found
                    String message = "<HTML><bODY><P>Δεν βρέθηκαν αποτελέσματα</P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, message, "No matches", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    //Create Table
                    charactersinScene = Table.read().db(sceneRS);
                    System.out.println("Characters in " + selectedScenes.get(0) + " Table: " + charactersinScene);
                }

                //STATISTICS
                if (InfoCheckBox.isSelected()) {
                    int dialogueCount = 0;
                    //COUNT DIALOGUE
                    PreparedStatement countdialogueResult = con.prepareStatement("SELECT COUNT(Διάλογος) FROM διάλογοι WHERE Όνομα = ? "
                            + "AND (Σκηνή = ? OR Σκηνή = ? OR Σκηνή = ?) AND Έργο = ?");
                    countdialogueResult.setString(1, selectedCharacters.get(0));
                    countdialogueResult.setInt(2, Integer.parseInt(selectedScenes.get(0).replaceAll("SCENE ", "")));
                    countdialogueResult.setInt(3, Integer.parseInt(selectedScenes.get(1).replaceAll("SCENE ", "")));
                    countdialogueResult.setInt(4, Integer.parseInt(selectedScenes.get(2).replaceAll("SCENE ", "")));
                    countdialogueResult.setInt(5, playID);
                    ResultSet countdialogueRS = countdialogueResult.executeQuery();
                    if (countdialogueRS.next()) {
                        dialogueCount = countdialogueRS.getInt("COUNT(Διάλογος)");
                    }
                    String statisticsMessage = "<HTML><BODY><P>Σύνολο Διαλόγων: <B>" + dialogueCount + "</B><BR></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, statisticsMessage, "Στατιστικά", JOptionPane.INFORMATION_MESSAGE);
                }
                //WORD COUNT
                if (WordCountCheckBox.isSelected()) {
                    int dialogueCounter = 0;
                    int stagedirectionsCounter = 0;
                    PreparedStatement wordCountResult = con.prepareStatement("SELECT Όνομα, Διάλογος, Σκηνικές_Οδηγίες FROM διάλογοι WHERE Όνομα = ?"
                            + "AND (Σκηνή = ? OR Σκηνή = ? OR Σκηνή = ?) AND Έργο = ?");
                    wordCountResult.setString(1, selectedCharacters.get(0));
                    wordCountResult.setInt(2, Integer.parseInt(selectedScenes.get(0).replaceAll("SCENE ", "")));
                    wordCountResult.setInt(3, Integer.parseInt(selectedScenes.get(1).replaceAll("SCENE ", "")));
                    wordCountResult.setInt(4, Integer.parseInt(selectedScenes.get(2).replaceAll("SCENE ", "")));
                    wordCountResult.setInt(5, playID);
                    ResultSet wordCountRS = wordCountResult.executeQuery();
                    while (wordCountRS.next()) {
                        dialogue.add(wordCountRS.getString("Διάλογος"));
                        stageDirections.add(wordCountRS.getString("Σκηνικές_Οδηγίες"));
                    }
                    for (int i = 0; i < dialogue.size(); i++) {
                        if (dialogue.get(i).isEmpty() == false) {
                            int count = wordCounter(dialogue.get(i));
                            dialogueCounter += count;
                        }
                    }
                    for (int i = 0; i < stageDirections.size(); i++) {
                        if (stageDirections.get(i).isEmpty() == false) {
                            int count = wordCounter(stageDirections.get(i));
                            stagedirectionsCounter += count;
                        }
                    }
                    String message2 = "<HTML><BODY><P>Αριθμός Λέξεων Διαλόγων:  <B>" + dialogueCounter + "</B><BR><BR>"
                            + "<P>Αριθμος Λέξεων Σκηνικών Οδηγιών: <B>" + stagedirectionsCounter + "</B></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, message2, "Διάλογοι και Σκηνικές Οδηγίες", JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS
                if (CrossTabsCheckBox.isSelected()) {
                    Table tabs = charactersinScene.xTabCounts("Όνομα", "Σκηνή");
                    String info = "Χαρακτήρας x Σκηνές Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(300, 300));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS (%)
                if (CrossPercentCheckBox.isSelected()) {
                    Table tabs = charactersinScene.xTabTablePercents("Όνομα", "Σκηνή");
                    tabs.columnsOfType(ColumnType.DOUBLE).forEach(x -> ((NumberColumn) x).setPrintFormatter(NumberColumnFormatter.percent(2)));
                    String info = "Χαρακτήρας x Σκηνές Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(300, 300));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }
            }

            if (DataList.getSelectedValue().equals("ΠΡΑΞΕΙΣ")) {
                int actCount = 0;

                PreparedStatement actResult = con.prepareStatement("SELECT * FROM διάλογοι WHERE Έργο = ?");
                actResult.setInt(1, playID);
                ResultSet actRS = actResult.executeQuery();
                //Create Table
                acts = Table.read().db(actRS);
                System.out.println("Acts Table: " + acts);

                //STATISTICS
                if (PlayStatisticsCheckBox.isSelected()) {
                    int dialogueCount = 0;
                    int count1 = 0;
                    int count2 = 0;
                    int count3 = 0;
                    int count4 = 0;
                    int count5 = 0;
                    double count = 0.0;
                    ArrayList<Integer> c = new ArrayList<Integer>();

                    if (actsList.size() == 3) {
                        //COUNT ACT
                        PreparedStatement countactResult = con.prepareStatement("SELECT COUNT(DISTINCT Πράξη) FROM διάλογοι WHERE Έργο = ?");
                        countactResult.setInt(1, playID);
                        ResultSet countactRS = countactResult.executeQuery();
                        if (countactRS.next()) {
                            actCount = countactRS.getInt("COUNT(DISTINCT Πράξη)");
                        }
                        PreparedStatement Result1 = con.prepareStatement("SELECT COUNT(DISTINCT Όνομα) FROM διάλογοι WHERE Πράξη = ? AND Έργο = ?");
                        Result1.setInt(1, 1);
                        Result1.setInt(2, playID);
                        ResultSet RS1 = Result1.executeQuery();
                        if (RS1.next()) {
                            count1 = RS1.getInt("COUNT(DISTINCT Όνομα)");
                            c.add(count1);
                        }
                        PreparedStatement Result2 = con.prepareStatement("SELECT COUNT(DISTINCT Όνομα) FROM διάλογοι WHERE Πράξη = ? AND Έργο = ?");
                        Result2.setInt(1, 2);
                        Result2.setInt(2, playID);
                        ResultSet RS2 = Result2.executeQuery();
                        if (RS2.next()) {
                            count2 = RS2.getInt("COUNT(DISTINCT Όνομα)");
                            c.add(count2);
                        }
                        PreparedStatement Result3 = con.prepareStatement("SELECT COUNT(DISTINCT Όνομα) FROM διάλογοι WHERE Πράξη = ? AND Έργο = ?");
                        Result3.setInt(1, 3);
                        Result3.setInt(2, playID);
                        ResultSet RS3 = Result3.executeQuery();
                        if (RS3.next()) {
                            count3 = RS3.getInt("COUNT(DISTINCT Όνομα)");
                            c.add(count3);
                        }
                        for (int i = 0; i < c.size(); i++) {
                            count += c.get(i);
                        }
                        count = count / 3;
                        String Statistics = "<HTML><BODY><P>Σύνολο Πράξεων: <B>" + actCount + "</B><BR>"
                                + "Μέσος όρος Χαρακτήρων ανά Πράξη: <B>" + count + "</B><BR></P></BODY></HTML>";
                        JOptionPane.showMessageDialog(this, Statistics, "Στατιστικά", JOptionPane.INFORMATION_MESSAGE);

                    } else if (actsList.size() == 4) {
                        //COUNT ACT
                        PreparedStatement countactResult = con.prepareStatement("SELECT COUNT(DISTINCT Πράξη) FROM διάλογοι WHERE Έργο = ?");
                        countactResult.setInt(1, playID);
                        ResultSet countactRS = countactResult.executeQuery();
                        if (countactRS.next()) {
                            actCount = countactRS.getInt("COUNT(DISTINCT Πράξη)");
                        }
                        //AVG
                        PreparedStatement Result1 = con.prepareStatement("SELECT COUNT(DISTINCT Όνομα) FROM διάλογοι WHERE Πράξη = ? AND Έργο = ?");
                        Result1.setInt(1, 1);
                        Result1.setInt(2, playID);
                        ResultSet RS1 = Result1.executeQuery();
                        if (RS1.next()) {
                            count1 = RS1.getInt("COUNT(DISTINCT Όνομα)");
                            c.add(count1);
                        }
                        PreparedStatement Result2 = con.prepareStatement("SELECT COUNT(DISTINCT Όνομα) FROM διάλογοι WHERE Πράξη = ? AND Έργο = ?");
                        Result2.setInt(1, 2);
                        Result2.setInt(2, playID);
                        ResultSet RS2 = Result2.executeQuery();
                        if (RS2.next()) {
                            count2 = RS2.getInt("COUNT(DISTINCT Όνομα)");
                            c.add(count2);
                        }
                        PreparedStatement Result3 = con.prepareStatement("SELECT COUNT(DISTINCT Όνομα) FROM διάλογοι WHERE Πράξη = ? AND Έργο = ?");
                        Result3.setInt(1, 3);
                        Result3.setInt(2, playID);
                        ResultSet RS3 = Result3.executeQuery();
                        if (RS3.next()) {
                            count3 = RS3.getInt("COUNT(DISTINCT Όνομα)");
                            c.add(count3);
                        }
                        PreparedStatement Result4 = con.prepareStatement("SELECT COUNT(DISTINCT Όνομα) FROM διάλογοι WHERE Πράξη = ? AND Έργο = ?");
                        Result4.setInt(1, 4);
                        Result4.setInt(2, playID);
                        ResultSet RS4 = Result4.executeQuery();
                        if (RS4.next()) {
                            count4 = RS4.getInt("COUNT(DISTINCT Όνομα)");
                            c.add(count4);
                        }
                        for (int i = 0; i < c.size(); i++) {
                            count += c.get(i);
                        }
                        count = count / 4;
                        String Statistics = "<HTML><BODY><P>Σύνολο Πράξεων: <B>" + actCount + "</B><BR>"
                                + "Μέσος όρος Χαρακτήρων ανά Πράξη: <B>" + count + "</B><BR></P></BODY></HTML>";
                        JOptionPane.showMessageDialog(this, Statistics, "Στατιστικά", JOptionPane.INFORMATION_MESSAGE);

                        //WORD COUNT
                        if (PlayWordCountCheckBox.isSelected()) {
                            int dialogueCounter = 0;
                            int stagedirectionsCounter = 0;
                            PreparedStatement wordCountResult = con.prepareStatement("SELECT * FROM διάλογοι WHERE Έργο = ?");
                            wordCountResult.setInt(1, playID);
                            ResultSet wordCountRS = wordCountResult.executeQuery();
                            while (wordCountRS.next()) {
                                dialogue.add(wordCountRS.getString("Διάλογος"));
                                stageDirections.add(wordCountRS.getString("Σκηνικές_Οδηγίες"));
                            }
                            for (int i = 0; i < dialogue.size(); i++) {
                                if (dialogue.get(i).isEmpty() == false) {
                                    int counter = wordCounter(dialogue.get(i));
                                    dialogueCounter += count;
                                }
                            }
                            for (int i = 0; i < stageDirections.size(); i++) {
                                if (stageDirections.get(i).isEmpty() == false) {
                                    int counter = wordCounter(stageDirections.get(i));
                                    stagedirectionsCounter += count;
                                }
                            }
                            String message2 = "<HTML><BODY><P>Αριθμός Λέξεων Διαλόγων:  <B>" + dialogueCounter + "</B><BR><BR>"
                                    + "<P>Αριθμος Λέξεων Σκηνικών Οδηγιών: <B>" + stagedirectionsCounter + "</B></P></BODY></HTML>";
                            JOptionPane.showMessageDialog(this, message2, "Διάλογοι και Σκηνικές Οδηγίες", JOptionPane.INFORMATION_MESSAGE);

                            //CROSS TABS
                            if (PlayCrossTabsCheckBox.isSelected()) {
                                Table tabs = acts.xTabCounts("Όνομα", "Πράξη");
                                String info = "Πράξεις x Χαρακτήρες Έργου";
                                String message3 = tabs.toString();
                                JTextArea Area = new JTextArea(message3);
                                //Set Font to get Table aligned content
                                Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                                Area.setEditable(false);
                                JScrollPane scrollPane = new JScrollPane(Area);
                                scrollPane.setPreferredSize(new Dimension(600, 500));
                                JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                            }

                            //CROSS TABS (%)
                            if (PlayCrossPercentCheckBox.isSelected()) {
                                Table tabs = acts.xTabTablePercents("Όνομα", "Πράξη");
                                tabs.columnsOfType(ColumnType.DOUBLE).forEach(x -> ((NumberColumn) x).setPrintFormatter(NumberColumnFormatter.percent(2)));
                                String info = "Πράξεις x Χαρακτήρες Έργου";
                                String message3 = tabs.toString();
                                JTextArea Area = new JTextArea(message3);
                                //Set Font to get Table aligned content
                                Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                                Area.setEditable(false);
                                JScrollPane scrollPane = new JScrollPane(Area);
                                scrollPane.setPreferredSize(new Dimension(600, 500));
                                JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    } else if (actsList.size() == 5) {
                        //COUNT ACT
                        PreparedStatement countactResult = con.prepareStatement("SELECT COUNT(DISTINCT Πράξη) FROM διάλογοι WHERE Έργο = ?");
                        countactResult.setInt(1, playID);
                        ResultSet countactRS = countactResult.executeQuery();
                        if (countactRS.next()) {
                            actCount = countactRS.getInt("COUNT(DISTINCT Πράξη)");
                        }
                        //AVG
                        PreparedStatement Result1 = con.prepareStatement("SELECT COUNT(DISTINCT Όνομα) FROM διάλογοι WHERE Πράξη = ? AND Έργο = ?");
                        Result1.setInt(1, 1);
                        Result1.setInt(2, playID);
                        ResultSet RS1 = Result1.executeQuery();
                        if (RS1.next()) {
                            count1 = RS1.getInt("COUNT(DISTINCT Όνομα)");
                            c.add(count1);
                        }
                        PreparedStatement Result2 = con.prepareStatement("SELECT COUNT(DISTINCT Όνομα) FROM διάλογοι WHERE Πράξη = ? AND Έργο = ?");
                        Result2.setInt(1, 2);
                        Result2.setInt(2, playID);
                        ResultSet RS2 = Result2.executeQuery();
                        if (RS2.next()) {
                            count2 = RS2.getInt("COUNT(DISTINCT Όνομα)");
                            c.add(count2);
                        }
                        PreparedStatement Result3 = con.prepareStatement("SELECT COUNT(DISTINCT Όνομα) FROM διάλογοι WHERE Πράξη = ? AND Έργο = ?");
                        Result3.setInt(1, 3);
                        Result3.setInt(2, playID);
                        ResultSet RS3 = Result3.executeQuery();
                        if (RS3.next()) {
                            count3 = RS3.getInt("COUNT(DISTINCT Όνομα)");
                            c.add(count3);
                        }
                        PreparedStatement Result4 = con.prepareStatement("SELECT COUNT(DISTINCT Όνομα) FROM διάλογοι WHERE Πράξη = ? AND Έργο = ?");
                        Result4.setInt(1, 4);
                        Result4.setInt(2, playID);
                        ResultSet RS4 = Result4.executeQuery();
                        if (RS4.next()) {
                            count4 = RS4.getInt("COUNT(DISTINCT Όνομα)");
                            c.add(count4);
                        }
                        PreparedStatement Result5 = con.prepareStatement("SELECT COUNT(DISTINCT Όνομα) FROM διάλογοι WHERE Πράξη = ? AND Έργο = ?");
                        Result5.setInt(1, 5);
                        Result5.setInt(2, playID);
                        ResultSet RS5 = Result5.executeQuery();
                        if (RS5.next()) {
                            count5 = RS5.getInt("COUNT(DISTINCT Όνομα)");
                            c.add(count5);
                        }
                        for (int i = 0; i < c.size(); i++) {
                            count += c.get(i);
                        }
                        count = count / 5;
                        String Statistics = "<HTML><BODY><P>Σύνολο Πράξεων: <B>" + actCount + "</B><BR>"
                                + "Μέσος όρος Χαρακτήρων ανά Πράξη: <B>" + count + "</B><BR></P></BODY></HTML>";
                        JOptionPane.showMessageDialog(this, Statistics, "Στατιστικά", JOptionPane.INFORMATION_MESSAGE);

                        //WORD COUNT
                        if (PlayWordCountCheckBox.isSelected()) {
                            int dialogueCounter = 0;
                            int stagedirectionsCounter = 0;
                            PreparedStatement wordCountResult = con.prepareStatement("SELECT * FROM διάλογοι WHERE Έργο = ?");
                            wordCountResult.setInt(1, playID);
                            ResultSet wordCountRS = wordCountResult.executeQuery();
                            while (wordCountRS.next()) {
                                dialogue.add(wordCountRS.getString("Διάλογος"));
                                stageDirections.add(wordCountRS.getString("Σκηνικές_Οδηγίες"));
                            }
                            for (int i = 0; i < dialogue.size(); i++) {
                                if (dialogue.get(i).isEmpty() == false) {
                                    int counter = wordCounter(dialogue.get(i));
                                    dialogueCounter += count;
                                }
                            }
                            for (int i = 0; i < stageDirections.size(); i++) {
                                if (stageDirections.get(i).isEmpty() == false) {
                                    int counter = wordCounter(stageDirections.get(i));
                                    stagedirectionsCounter += count;
                                }
                            }
                            String message2 = "<HTML><BODY><P>Αριθμός Λέξεων Διαλόγων:  <B>" + dialogueCounter + "</B><BR><BR>"
                                    + "<P>Αριθμος Λέξεων Σκηνικών Οδηγιών: <B>" + stagedirectionsCounter + "</B></P></BODY></HTML>";
                            JOptionPane.showMessageDialog(this, message2, "Διάλογοι και Σκηνικές Οδηγίες", JOptionPane.INFORMATION_MESSAGE);
                        }

                    }
                }

                //WORD COUNT
                if (PlayWordCountCheckBox.isSelected()) {
                    int dialogueCounter = 0;
                    int stagedirectionsCounter = 0;
                    PreparedStatement wordCountResult = con.prepareStatement("SELECT * FROM διάλογοι WHERE Έργο = ?");
                    wordCountResult.setInt(1, playID);
                    ResultSet wordCountRS = wordCountResult.executeQuery();
                    while (wordCountRS.next()) {
                        dialogue.add(wordCountRS.getString("Διάλογος"));
                        stageDirections.add(wordCountRS.getString("Σκηνικές_Οδηγίες"));
                    }
                    for (int i = 0; i < dialogue.size(); i++) {
                        if (dialogue.get(i).isEmpty() == false) {
                            int count = wordCounter(dialogue.get(i));
                            dialogueCounter += count;
                        }
                    }
                    for (int i = 0; i < stageDirections.size(); i++) {
                        if (stageDirections.get(i).isEmpty() == false) {
                            int count = wordCounter(stageDirections.get(i));
                            stagedirectionsCounter += count;
                        }
                    }
                    String message2 = "<HTML><BODY><P>Αριθμός Λέξεων Διαλόγων:  <B>" + dialogueCounter + "</B><BR><BR>"
                            + "<P>Αριθμος Λέξεων Σκηνικών Οδηγιών: <B>" + stagedirectionsCounter + "</B></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, message2, "Διάλογοι και Σκηνικές Οδηγίες", JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS
                if (PlayCrossTabsCheckBox.isSelected()) {
                    Table tabs = acts.xTabCounts("Όνομα", "Πράξη");
                    String info = "Πράξεις x Χαρακτήρες Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(600, 500));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS (%)
                if (PlayCrossPercentCheckBox.isSelected()) {
                    Table tabs = acts.xTabTablePercents("Όνομα", "Πράξη");
                    tabs.columnsOfType(ColumnType.DOUBLE).forEach(x -> ((NumberColumn) x).setPrintFormatter(NumberColumnFormatter.percent(2)));
                    String info = "Πράξεις x Χαρακτήρες Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(600, 500));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }

                //PLOTS
                Table t = acts.xTabCounts("Πράξη");
                //Pie Chart
                if (PlotComboBox.getSelectedItem().equals("Πίτα")) {
                    Layout layout = Layout.builder().title("ΠΡΑΞΕΙΣ ΕΡΓΟΥ").height(600).width(1200).build();
                    PieTrace trace = PieTrace.builder(t.column("Category"), t.numberColumn("Count")).showLegend(true).build();
                    Plot.show(new Figure(layout, trace));
                    //Bar Chart    
                } else if (PlotComboBox.getSelectedItem().equals("Ραβδόγραμμα")) {
                    Layout layout = Layout.builder().title("ΠΡΑΞΕΙΣ ΕΡΓΟΥ").height(600).width(1200).build();
                    BarTrace trace = BarTrace.builder(t.categoricalColumn("Category"), t.numberColumn("Count")).showLegend(true).build();
                    Plot.show(new Figure(layout, trace));
                }
            }

            if (DataList.getSelectedValue().equals("ΣΚΗΝΕΣ")) {
                int sceneCount = 0;
                PreparedStatement sceneResult = con.prepareStatement("SELECT * FROM διάλογοι WHERE Έργο = ?");
                sceneResult.setInt(1, playID);
                ResultSet sceneRS = sceneResult.executeQuery();
                //Create Table
                scenes = Table.read().db(sceneRS);
                System.out.println("Scenes Table: " + scenes);

                //STATISTICS
                if (PlayStatisticsCheckBox.isSelected()) {
                    int dialogueCount = 0;
                    //COUNT DIALOGUE
                    PreparedStatement countactResult = con.prepareStatement("SELECT COUNT(DISTINCT Σκηνή) FROM διάλογοι WHERE Έργο = ?");
                    countactResult.setInt(1, playID);
                    ResultSet countactRS = countactResult.executeQuery();
                    if (countactRS.next()) {
                        sceneCount = countactRS.getInt("COUNT(DISTINCT Σκηνή)");
                    }
                    String statisticsMessage = "<HTML><BODY><P>Σύνολο Σκηνών: <B>" + sceneCount + "</B><BR></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, statisticsMessage, "Στατιστικά", JOptionPane.INFORMATION_MESSAGE);
                }
                //WORD COUNT
                if (PlayWordCountCheckBox.isSelected()) {
                    int dialogueCounter = 0;
                    int stagedirectionsCounter = 0;
                    PreparedStatement wordCountResult = con.prepareStatement("SELECT * FROM διάλογοι WHERE Έργο = ?");
                    wordCountResult.setInt(1, playID);
                    ResultSet wordCountRS = wordCountResult.executeQuery();
                    while (wordCountRS.next()) {
                        dialogue.add(wordCountRS.getString("Διάλογος"));
                        stageDirections.add(wordCountRS.getString("Σκηνικές_Οδηγίες"));
                    }
                    for (int i = 0; i < dialogue.size(); i++) {
                        if (dialogue.get(i).isEmpty() == false) {
                            int count = wordCounter(dialogue.get(i));
                            dialogueCounter += count;
                        }
                    }
                    for (int i = 0; i < stageDirections.size(); i++) {
                        if (stageDirections.get(i).isEmpty() == false) {
                            int count = wordCounter(stageDirections.get(i));
                            stagedirectionsCounter += count;
                        }
                    }
                    String message2 = "<HTML><BODY><P>Αριθμός Λέξεων Διαλόγων:  <B>" + dialogueCounter + "</B><BR><BR>"
                            + "<P>Αριθμος Λέξεων Σκηνικών Οδηγιών: <B>" + stagedirectionsCounter + "</B></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, message2, "Διάλογοι και Σκηνικές Οδηγίες", JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS
                if (PlayCrossTabsCheckBox.isSelected()) {
                    Table tabs = scenes.xTabCounts("Όνομα", "Σκηνή");
                    String info = "Σκηνές x Χαρακτήρες Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(600, 500));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS (%)
                if (PlayCrossPercentCheckBox.isSelected()) {
                    Table tabs = scenes.xTabTablePercents("Όνομα", "Σκηνή");
                    tabs.columnsOfType(ColumnType.DOUBLE).forEach(x -> ((NumberColumn) x).setPrintFormatter(NumberColumnFormatter.percent(2)));
                    String info = "Σκηνές x Χαρακτήρες Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(600, 500));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }

                //PLOTS
                Table t = scenes.xTabCounts("Σκηνή");
                //Pie Chart
                if (PlotComboBox.getSelectedItem().equals("Πίτα")) {
                    Layout layout = Layout.builder().title("ΣΚΗΝΕΣ ΕΡΓΟΥ").height(600).width(1200).build();
                    PieTrace trace = PieTrace.builder(t.column("Category"), t.numberColumn("Count")).showLegend(true).build();
                    Plot.show(new Figure(layout, trace));
                    //Bar Chart    
                } else if (PlotComboBox.getSelectedItem().equals("Ραβδόγραμμα")) {
                    Layout layout = Layout.builder().title("ΣΚΗΝΕΣ ΕΡΓΟΥ").height(600).width(1200).build();
                    BarTrace trace = BarTrace.builder(t.categoricalColumn("Category"), t.numberColumn("Count")).showLegend(true).build();
                    Plot.show(new Figure(layout, trace));
                }
            }

            if (DataList.getSelectedValue().equals("ΧΑΡΑΚΤΗΡΕΣ")) {
                int charCount = 0;
                PreparedStatement charResult = con.prepareStatement("SELECT * FROM διάλογοι WHERE Έργο = ?");
                charResult.setInt(1, playID);
                ResultSet charRS = charResult.executeQuery();
                //Create Table
                characters = Table.read().db(charRS);
                System.out.println("Scenes Table: " + characters);

                //WORD COUNT
                if (PlayWordCountCheckBox.isSelected()) {
                    int dialogueCounter = 0;
                    int stagedirectionsCounter = 0;
                    PreparedStatement wordCountResult = con.prepareStatement("SELECT * FROM διάλογοι WHERE Έργο = ?");
                    wordCountResult.setInt(1, playID);
                    ResultSet wordCountRS = wordCountResult.executeQuery();
                    while (wordCountRS.next()) {
                        dialogue.add(wordCountRS.getString("Διάλογος"));
                        stageDirections.add(wordCountRS.getString("Σκηνικές_Οδηγίες"));
                    }
                    for (int i = 0; i < dialogue.size(); i++) {
                        if (dialogue.get(i).isEmpty() == false) {
                            int count = wordCounter(dialogue.get(i));
                            dialogueCounter += count;
                        }
                    }
                    for (int i = 0; i < stageDirections.size(); i++) {
                        if (stageDirections.get(i).isEmpty() == false) {
                            int count = wordCounter(stageDirections.get(i));
                            stagedirectionsCounter += count;
                        }
                    }
                    String message2 = "<HTML><BODY><P>Αριθμός Λέξεων Διαλόγων:  <B>" + dialogueCounter + "</B><BR><BR>"
                            + "<P>Αριθμος Λέξεων Σκηνικών Οδηγιών: <B>" + stagedirectionsCounter + "</B></P></BODY></HTML>";
                    JOptionPane.showMessageDialog(this, message2, "Διάλογοι και Σκηνικές Οδηγίες", JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS
                if (PlayCrossTabsCheckBox.isSelected()) {
                    Table tabs = characters.xTabCounts("Όνομα", "Πράξη");
                    String info = "Χαρακτήρες x Πράξεις Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(600, 500));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }

                //CROSS TABS (%)
                if (PlayCrossPercentCheckBox.isSelected()) {
                    Table tabs = characters.xTabTablePercents("Όνομα", "Πράξη");
                    tabs.columnsOfType(ColumnType.DOUBLE).forEach(x -> ((NumberColumn) x).setPrintFormatter(NumberColumnFormatter.percent(2)));
                    String info = "Χαρακτήρες x Πράξεις Έργου";
                    String message3 = tabs.toString();
                    JTextArea Area = new JTextArea(message3);
                    //Set Font to get Table aligned content
                    Area.setFont(new Font("monospaced", Font.PLAIN, 12));
                    Area.setEditable(false);
                    JScrollPane scrollPane = new JScrollPane(Area);
                    scrollPane.setPreferredSize(new Dimension(600, 500));
                    JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
                }

                //PLOTS
                Table t = characters.xTabCounts("Όνομα");
                //Pie Chart
                if (PlotComboBox.getSelectedItem().equals("Πίτα")) {
                    Layout layout = Layout.builder().title("ΧΑΡΑΚΤΗΡΕΣ ΕΡΓΟΥ").height(600).width(1200).build();
                    PieTrace trace = PieTrace.builder(t.column("Category"), t.numberColumn("Count")).showLegend(true).build();
                    Plot.show(new Figure(layout, trace));
                    //Bar Chart    
                } else if (PlotComboBox.getSelectedItem().equals("Ραβδόγραμμα")) {
                    Layout layout = Layout.builder().title("ΧΑΡΑΚΤΗΡΕΣ ΕΡΓΟΥ").height(600).width(1200).build();
                    BarTrace trace = BarTrace.builder(t.categoricalColumn("Category"), t.numberColumn("Count")).showLegend(true).build();
                    Plot.show(new Figure(layout, trace));
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }//GEN-LAST:event_AnalysisButtonActionPerformed

    private void PlayInfoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlayInfoButtonActionPerformed
        String info = "Πληροφορίες Έργου";
        if (!charList.isEmpty()) {
            charList.clear();
        }
        String message = "Τίτλος: " + Title.getTextContent() + "\n"
                + "\n Συγγραφέας: " + AuthorName.getTextContent() + "\n"
                + "\n Χαρακτήρες: " + "\n" + charList + "\n"
                + "\n Πράξεις: " + actNumber + "\n"
                + "\n Σκηνές: " + scenes;
        JTextArea Area = new JTextArea(message);
        JScrollPane scrollPane = new JScrollPane(Area);
        Area.setLineWrap(true);
        Area.setWrapStyleWord(true);
        Area.setEditable(false);
        scrollPane.setPreferredSize(new Dimension(400, 400));
        JOptionPane.showMessageDialog(null, scrollPane, info, JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_PlayInfoButtonActionPerformed

    private void SaveButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SaveButtonActionPerformed
        if (XMLEditorPane.getText().isEmpty()) {
            String dialog = "Άδειο Κείμενο";
            JOptionPane.showMessageDialog(new JFrame(), "Το κείμενο είναι άδειο!", dialog, JOptionPane.ERROR_MESSAGE);
        } else {
            JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
            JFileChooser exportfileChooser = new JFileChooser();
            exportfileChooser.setDialogTitle("Αποθήκευση αρχείου");
            int userSelection = exportfileChooser.showSaveDialog(frame);

            if (userSelection == JFileChooser.APPROVE_OPTION) {
                PrintWriter writer = null;
                try {
                    //Write to file
                    writer = new PrintWriter(new OutputStreamWriter(new FileOutputStream(exportfileChooser.getSelectedFile(), true), StandardCharsets.UTF_8));
                    writer.println(XMLEditorPane.getText());
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                writer.close();
                //File to Save
                File savedFile = exportfileChooser.getSelectedFile();
                System.out.println("Saved as: " + savedFile.getAbsolutePath());
            }
        }
    }//GEN-LAST:event_SaveButtonActionPerformed

    private void XMLValidationButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_XMLValidationButtonActionPerformed
        if (XMLEditorPane.getText().isEmpty()) {
            String dialog = "Άδειο Κείμενο";
            JOptionPane.showMessageDialog(new JFrame(), "Το κείμενο είναι άδειο!", dialog, JOptionPane.ERROR_MESSAGE);
        } else {
            //URL Schema (xsd) example:
            //URL schemaFile = new URL("http://host:port/filename.xsd");
            //Local Schema (xsd) example:
            File schemaFile = new File("C:\\Users\\ΔΗΜΗΤΡΗΣ\\Desktop\\plays.xsd");
            //Get XML from EditorPane to String
            String validation = XMLEditorPane.getText();

            //Source xmlFile = new StreamSource(new File("C:\\Users\\ΔΗΜΗΤΡΗΣ\\Desktop\\Master Builder.xml"));
            //File f = myXMLFile;
            //System.out.println(myXMLFile.getAbsolutePath());
            Source xmlFile = new StreamSource(new StringReader(validation));
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            try {
                Schema schema = schemaFactory.newSchema(schemaFile);
                Validator validator = schema.newValidator();
                validator.validate(xmlFile);
                String valid = "Έγκυρο XML αρχείο";
                JOptionPane.showMessageDialog(new JFrame(), "Το XML αρχείο είναι έγκυρο", valid, JOptionPane.INFORMATION_MESSAGE);
                //Enable Info button
                PlayInfoButton.setEnabled(true);
                //Enable Save button
                SaveButton.setEnabled(true);
                DatabaseButton.setEnabled(true);
                //Enable Analysis
                AnalysisButton.setEnabled(true);
                PlotComboBox.setEnabled(true);
                InfoCheckBox.setEnabled(true);
            } catch (SAXException e) {
                String invalid = "Μη έγκυρο XML αρχείο";
                //Get error line number
                String errorline = e.toString().split(";")[1];
                errorline = errorline.replaceAll("[^0-9]", " ").trim();
                JOptionPane.showMessageDialog(this, "<html><body><p style='width: 300px;'>" + e.getMessage() + "\n (Γραμμή: " + errorline + ")", invalid, JOptionPane.WARNING_MESSAGE);
            } catch (IOException e) {
            }
        }
    }//GEN-LAST:event_XMLValidationButtonActionPerformed

    private void DatabaseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatabaseButtonActionPerformed

        String dbUrl = "jdbc:mysql://localhost/theatrical_plays?useUnicode=true&character_set_server=utf8mb4&characterEncoding=UTF-8";
        String username = "root";
        String password = "root123456";

        if (dbTitles.contains(PlaysList.getSelectedValue())) {
            //Play already exists in the Database
            String message = "<HTML><bODY><P>Το Έργο υπάρχει ήδη στη Βάση!</P></BODY></HTML>";
            JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.INFORMATION_MESSAGE);

            try {
                //Create connection
                java.sql.Connection con = DriverManager.getConnection(dbUrl, username, password);

                ActAnalysisList.setEnabled(true);
                SceneAnalysisList.setEnabled(true);
                CharacterAnalysisList.setEnabled(true);
                actsList.clear();
                scenesList.clear();
                charactersList.clear();

                //Get Acts of Play
                PreparedStatement actsResult = con.prepareStatement("SELECT DISTINCT Πράξη FROM διάλογοι WHERE Έργο = ?");
                actsResult.setInt(1, playID);
                ResultSet actsRS = actsResult.executeQuery();
                //Get all data
                while (actsRS.next()) {
                    actsList.add(actsRS.getString("Πράξη").replaceAll("1", "ACT 1").replaceAll("2", "ACT 2")
                            .replaceAll("3", "ACT 3").replaceAll("4", "ACT 4").replaceAll("5", "ACT 5"));
                }
                //Load Acts on List
                String[] playActs = new String[actsList.size()];
                ActAnalysisList.setListData(actsList.toArray(playActs));

                //Get Scenes of Play
                PreparedStatement scenesResult = con.prepareStatement("SELECT DISTINCT Σκηνή FROM διάλογοι WHERE Έργο = ?");
                scenesResult.setInt(1, playID);
                ResultSet scenesRS = scenesResult.executeQuery();
                //Get all data
                while (scenesRS.next()) {
                    scenesList.add(scenesRS.getString("Σκηνή").replaceAll("1", "SCENE 1").replaceAll("2", "SCENE 2")
                            .replaceAll("3", "SCENE 3").replaceAll("4", "SCENE 4").replaceAll("5", "SCENE 5")
                            .replaceAll("6", "SCENE 6").replaceAll("7", "SCENE 7"));
                }
                if (scenesList.get(0).equals("0")) {
                    SceneAnalysisList.setEnabled(false);
                } else {
                    //Load Scenes on List
                    String[] playScenes = new String[scenesList.size()];
                    SceneAnalysisList.setListData(scenesList.toArray(playScenes));
                }

                //Get Characters of Play
                PreparedStatement charsResult = con.prepareStatement("SELECT Όνομα FROM χαρακτήρες WHERE Έργο = ?");
                charsResult.setInt(1, playID);
                ResultSet charsRS = charsResult.executeQuery();
                //Get all data
                while (charsRS.next()) {
                    charactersList.add(charsRS.getString("Όνομα"));
                }
                //Load Characters on List
                String[] playCharacters = new String[charactersList.size()];
                CharacterAnalysisList.setListData(charactersList.toArray(playCharacters));

                if (scenesList.get(0).equals("0") == false) {
                    ArrayList<String> values = new ArrayList<String>();
                    values.add("ΠΡΑΞΕΙΣ");
                    values.add("ΣΚΗΝΕΣ");
                    values.add("ΧΑΡΑΚΤΗΡΕΣ");

                    //Load Characters on List
                    String[] data = new String[values.size()];
                    DataList.setListData(values.toArray(data));
                } else {
                    ArrayList<String> values = new ArrayList<String>();
                    values.add("ΠΡΑΞΕΙΣ");
                    values.add("ΧΑΡΑΚΤΗΡΕΣ");

                    //Load Characters on List
                    String[] data = new String[values.size()];
                    DataList.setListData(values.toArray(data));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            try {
                //Create connection
                java.sql.Connection conn = DriverManager.getConnection(dbUrl, username, password);

                //Insert to Play table
                PreparedStatement playStmt = conn.prepareStatement("INSERT INTO Έργο "
                        + "(Έργο, Τίτλος, Συγγραφέας, Ημερομηνία_Κυκλοφορίας, Είδος, URL) "
                        + "VALUES (?, ?, ?, ?, ?, ?)");

                //Get XML nodes 
                nodelist = rootElement.getChildNodes();
                //Insert data to NodeList
                for (int i = 0; i < nodelist.getLength(); i++) {
                    Node node = nodelist.item(i);
                    if (node.getNodeName().contains("Έργο")) {
                        List<String> columns = Arrays.asList(getAttrValue(node, "id"),
                                getTextContent(node, "Τίτλος"),
                                getTextContent(node, "Συγγραφέας_ID"),
                                getTextContent(node, "Ημερομηνία_Κυκλοφορίας"),
                                getTextContent(node, "Είδος"),
                                getTextContent(node, "URL"));
                        System.out.println("ΕΙΣΑΓΩΓΗ ΣΤΟΝ ΠΙΝΑΚΑ ΕΡΓΟ: ");
                        for (int n = 0; n < columns.size(); n++) {
                            System.out.println(n + 1 + " - " + columns.get(n));
                            playStmt.setString(n + 1, columns.get(n));
                        }
                        playStmt.execute();
                        System.out.println("\n");
                    }
                }
                //Insert to Author table
                PreparedStatement authorStmt = conn.prepareStatement("INSERT INTO Συγγραφέας "
                        + "(Συγγραφέας, Όνομα, Ημερομηνία_Γέννησης, Βιογραφία) "
                        + "VALUES (?, ?, ?, ?) "
                        + "ON DUPLICATE KEY UPDATE "
                        + "Συγγραφέας = VALUES(Συγγραφέας)");
                //Select XML nodes
                nodelist = rootElement.getElementsByTagName("Συγγραφέας");
                //Insert data to NodeList
                for (int i = 0; i < nodelist.getLength(); i++) {
                    Node node = nodelist.item(i);
                    if (node.getNodeName().contains("Συγγραφέας")) {
                        List<String> columns = Arrays.asList(getAttrValue(node, "id"),
                                getTextContent(node, "Όνομα"),
                                getTextContent(node, "Ημερομηνία_Γέννησης"),
                                getTextContent(node, "Βιογραφία"));
                        System.out.println("ΕΙΣΑΓΩΓΗ ΣΤΟΝ ΠΙΝΑΚΑ ΣΥΓΓΡΑΦΕΑΣ: ");
                        for (int n = 0; n < columns.size(); n++) {
                            System.out.println(n + 1 + " - " + columns.get(n));
                            authorStmt.setString(n + 1, columns.get(n));
                        }
                        authorStmt.execute();
                        System.out.println("\n");
                    }
                }
                //Insert to Character table
                PreparedStatement characterStmt = conn.prepareStatement("INSERT INTO Χαρακτήρες "
                        + "(Έργο, Χαρακτήρας, Όνομα) "
                        + "VALUES (?, ?, ?)");
                //Select XML nodes
                nodelist = rootElement.getElementsByTagName("Χαρακτήρας");
                List<String> characterlist = new ArrayList();
                //Get each character once
                for (int i = 0; i < nodelist.getLength(); i++) {
                    NodeList childList = nodelist.item(i).getChildNodes();
                    for (int j = 0; j < childList.getLength(); j++) {
                        Node childNode = childList.item(j);
                        if ((childNode.getNodeName().equals("Όνομα"))) {
                            String name = childNode.getTextContent();
                            if (characterlist.contains(name)) {
                                break;
                            } else {
                                characterlist.add(name);
                            }
                        }
                    }
                }
                //Insert data to NodeList
                for (int i = 0; i < characterlist.size(); i++) {
                    String name = characterlist.get(i);
                    List<String> columns = Arrays.asList(String.valueOf(playID),
                            String.valueOf(characterlist.indexOf(name) + 1), name);
                    System.out.println("ΕΙΣΑΓΩΓΗ ΣΤΟΝ ΠΙΝΑΚΑ ΧΑΡΑΚΤΗΡΕΣ: ");
                    for (int n = 0; n < columns.size(); n++) {
                        System.out.println(n + 1 + " - " + columns.get(n));
                        characterStmt.setString(n + 1, columns.get(n));
                    }
                    characterStmt.execute();
                    System.out.println("\n");
                }
                //Insert to Diaogue table
                PreparedStatement dialogueStmt = conn.prepareStatement("INSERT INTO Διάλογοι "
                        + "(Αύξων_Αριθμός, Έργο, Χαρακτήρας, Όνομα, Διάλογος, Σκηνικές_Οδηγίες, Πράξη, Σκηνή) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
                //Select XML nodes
                nodelist = rootElement.getElementsByTagName("Έργο");
                String act = null;
                String scene = null;
                int serialNumber = 0;

                //Get each character once
                for (int i = 0; i < nodelist.getLength(); i++) {
                    //Element node = (Element) nodelist.item(i).getChildNodes();
                    NodeList childList = nodelist.item(i).getChildNodes();

                    for (int j = 0; j < childList.getLength(); j++) {
                        Node childNode = childList.item(j);

                        if (childNode.getNodeName().equals("Πράξη")) {
                            act = childNode.getAttributes().getNamedItem("Νούμερο").getNodeValue();
                            System.out.println("ACT: " + act);

                            NodeList childList2 = childList.item(j).getChildNodes();
                            for (int k = 0; k < childList2.getLength(); k++) {
                                Node childNode2 = childList2.item(k);

                                if (childNode2.getNodeName().equals("Σκηνή")) {
                                    scene = childNode2.getAttributes().getNamedItem("Νούμερο").getNodeValue();
                                    System.out.println("SCENE: " + scene);

                                    NodeList childList3 = childList2.item(k).getChildNodes();
                                    for (int l = 0; l < childList3.getLength(); l++) {
                                        Node childNode3 = childList3.item(l);

                                        if (childNode3.getNodeName().equals("Χαρακτήρας")) {
                                            serialNumber++;
                                            List<String> columns = Arrays.asList(String.valueOf(serialNumber),
                                                    String.valueOf(playID),
                                                    getAttrValue(childNode3, "id"),
                                                    getTextContent(childNode3, "Όνομα"),
                                                    getTextContent(childNode3, "Λόγος").replaceAll("�", "—"),
                                                    getTextContent(childNode3, "Σκηνικές_Οδηγίες"),
                                                    act,
                                                    scene);
                                            System.out.println("ΕΙΣΑΓΩΓΗ ΣΤΟΝ ΠΙΝΑΚΑ ΔΙΑΛΟΓΩΝ: ");
                                            for (int n = 0; n < columns.size(); n++) {
                                                System.out.println(n + 1 + " - " + columns.get(n));
                                                dialogueStmt.setString(n + 1, columns.get(n));
                                            }
                                            dialogueStmt.execute();
                                            System.out.println("\n");
                                        }
                                    }
                                } else if (childNode2.getNodeName().equals("Χαρακτήρας")) {
                                    serialNumber++;
                                    List<String> columns = Arrays.asList(String.valueOf(serialNumber),
                                            String.valueOf(playID),
                                            getAttrValue(childNode2, "id"),
                                            getTextContent(childNode2, "Όνομα"),
                                            getTextContent(childNode2, "Λόγος"),
                                            getTextContent(childNode2, "Σκηνικές_Οδηγίες"),
                                            act,
                                            "0");
                                    System.out.println("ΕΙΣΑΓΩΓΗ ΣΤΟΝ ΠΙΝΑΚΑ ΔΙΑΛΟΓΩΝ: ");
                                    for (int n = 0; n < columns.size(); n++) {
                                        System.out.println(n + 1 + " - " + columns.get(n));
                                        dialogueStmt.setString(n + 1, columns.get(n).replaceAll("�", "—"));
                                    }
                                    dialogueStmt.execute();
                                    System.out.println("\n");
                                }
                            }
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //Play successfully added in the database
            String message = "<HTML><bODY><P>Το Έργο μπήκε επιτυχώς στη Βάση</P></BODY></HTML>";
            JOptionPane.showMessageDialog(this, message, "Επιτυχής εισαγωγή Έργου", JOptionPane.INFORMATION_MESSAGE);

            try {
                //Create connection
                java.sql.Connection con = DriverManager.getConnection(dbUrl, username, password);

                PreparedStatement st = con.prepareStatement("SELECT Τίτλος FROM έργο");
                ResultSet rs = st.executeQuery();
                //Get all data
                while (rs.next()) {
                    if (!dbTitles.contains(rs.getString("Τίτλος"))) {
                        dbTitles.add(rs.getString("Τίτλος"));
                    }
                }

                ActAnalysisList.setEnabled(true);
                SceneAnalysisList.setEnabled(true);
                CharacterAnalysisList.setEnabled(true);
                actsList.clear();
                scenesList.clear();
                charactersList.clear();

                //Get Acts of Play
                PreparedStatement actsResult = con.prepareStatement("SELECT DISTINCT Πράξη FROM διάλογοι WHERE Έργο = ?");
                actsResult.setInt(1, playID);
                ResultSet actsRS = actsResult.executeQuery();
                //Get all data
                while (actsRS.next()) {
                    actsList.add(actsRS.getString("Πράξη").replaceAll("1", "ACT 1").replaceAll("2", "ACT 2")
                            .replaceAll("3", "ACT 3").replaceAll("4", "ACT 4").replaceAll("5", "ACT 5"));
                }
                //Load Acts on List
                String[] playActs = new String[actsList.size()];
                ActAnalysisList.setListData(actsList.toArray(playActs));

                //Get Scenes of Play
                PreparedStatement scenesResult = con.prepareStatement("SELECT DISTINCT Σκηνή FROM διάλογοι WHERE Έργο = ?");
                scenesResult.setInt(1, playID);
                ResultSet scenesRS = scenesResult.executeQuery();
                //Get all data
                while (scenesRS.next()) {
                    scenesList.add(scenesRS.getString("Σκηνή").replaceAll("1", "SCENE 1").replaceAll("2", "SCENE 2")
                            .replaceAll("3", "SCENE 3").replaceAll("4", "SCENE 4").replaceAll("5", "SCENE 5")
                            .replaceAll("6", "SCENE 6").replaceAll("7", "SCENE 7"));
                }
                if (scenesList.get(0).equals("0")) {
                    SceneAnalysisList.setEnabled(false);
                } else {
                    //Load Scenes on List
                    String[] playScenes = new String[scenesList.size()];
                    SceneAnalysisList.setListData(scenesList.toArray(playScenes));
                }

                //Get Characters of Play
                PreparedStatement charsResult = con.prepareStatement("SELECT Όνομα FROM χαρακτήρες WHERE Έργο = ?");
                charsResult.setInt(1, playID);
                ResultSet charsRS = charsResult.executeQuery();
                //Get all data
                while (charsRS.next()) {
                    charactersList.add(charsRS.getString("Όνομα"));
                }
                //Load Characters on List
                String[] playCharacters = new String[charactersList.size()];
                CharacterAnalysisList.setListData(charactersList.toArray(playCharacters));

                if (scenesList.get(0).equals("0") == false) {
                    ArrayList<String> values = new ArrayList<String>();
                    values.add("ΠΡΑΞΕΙΣ");
                    values.add("ΣΚΗΝΕΣ");
                    values.add("ΧΑΡΑΚΤΗΡΕΣ");

                    //Load Characters on List
                    String[] data = new String[values.size()];
                    DataList.setListData(values.toArray(data));
                } else {
                    ArrayList<String> values = new ArrayList<String>();
                    values.add("ΠΡΑΞΕΙΣ");
                    values.add("ΧΑΡΑΚΤΗΡΕΣ");

                    //Load Characters on List
                    String[] data = new String[values.size()];
                    DataList.setListData(values.toArray(data));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            PlaysList.setCellRenderer(new DatabaseListCellRenderer());
        }
    }//GEN-LAST:event_DatabaseButtonActionPerformed

    private void PlaysListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlaysListMouseClicked
        String title = "";
        urls.clear();
        crawlURL = "https://www.gutenberg.org/ebooks/search/?query=Plays&submit_search=Go%21";

        PlaysList.setCellRenderer(new SelectedListCellRenderer());
        PlaysList.setCellRenderer(new DatabaseListCellRenderer());
        //Get selected Play
        playTitle = PlaysList.getSelectedValue();

        //Get Play URL
        urls = CrawlURL(1, crawlURL, new ArrayList<String>(), playTitle, urls);
        //Print out Play URL
        playURL = urls.get(0);
        System.out.println(playURL);
        PlayURLLabel.setText("<HTML><B>URL Έργου: </B><FONT color=\"#000099\"><U>" + playURL + "</U></FONT></HTML>");
        PlayURLLabel.setToolTipText(playURL);
        PlayURLLabel.setVisible(true);
        //Get Play's URL file
        String urlFile = CrawlFileURL(playURL, new ArrayList<String>());
        File file = null;

        try {
            //Load Play
            LoadPlay(urlFile);
        } catch (IOException ex) {
            Logger.getLogger(LiteratureAnalyticsUI.class.getName()).log(Level.SEVERE, null, ex);
        }
        //Scrape Play and Load XML
        ScrapeandLoadXML(urlFile);
    }//GEN-LAST:event_PlaysListMouseClicked

    private void PlaysListMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlaysListMouseDragged
        HoveredListCellRenderer hover = new HoveredListCellRenderer();
        PlaysList.setCellRenderer(hover);
        PlaysList.addMouseListener(hover.getHandler(PlaysList));
        PlaysList.addMouseMotionListener(hover.getHandler(PlaysList));
        PlaysList.setCellRenderer(new DatabaseListCellRenderer());
    }//GEN-LAST:event_PlaysListMouseDragged

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        String dbUrl = "jdbc:mysql://localhost/theatrical_plays?useUnicode=true&character_set_server=utf8mb4&characterEncoding=UTF-8";
        String username = "root";
        String password = "root123456";

        //URL to be crawled
        crawlURL = "https://www.gutenberg.org/ebooks/search/?query=Plays&submit_search=Go%21";
        //Get all Play Titles
        CrawlTitle(1, crawlURL, new ArrayList<String>(), titles);
        //Clean Plays List
        CleanPlays(titles);
        //System.out.println("Titles size: " + titles.size());

        try {
            //Create connection
            java.sql.Connection con = DriverManager.getConnection(dbUrl, username, password);

            PreparedStatement st = con.prepareStatement("SELECT Τίτλος FROM έργο");
            ResultSet rs = st.executeQuery();
            //Get all data
            while (rs.next()) {
                if (!dbTitles.contains(rs.getString("Τίτλος"))) {
                    dbTitles.add(rs.getString("Τίτλος"));
                }
            }
            System.out.println("Database Titles : " + dbTitles);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        //Load Plays on List
        String[] playTitles = new String[titles.size()];
        PlaysList.setListData(titles.toArray(playTitles));
        PlaysList.setCellRenderer(new DatabaseListCellRenderer());
    }//GEN-LAST:event_formWindowOpened

    private void PlayURLLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_PlayURLLabelMouseClicked
        try {
            //Open Play URL in default Browser
            Desktop.getDesktop().browse(new URL(playURL).toURI());
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_PlayURLLabelMouseClicked

    private void PlaySearchTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PlaySearchTextFieldActionPerformed
        String playInput = PlaySearchTextField.getText();
        filteredTitles.clear();

        for (int i = 0; i < titles.size(); i++) {
            if (titles.get(i).contains(playInput)) {
                filteredTitles.add(titles.get(i));
            }
        }

        if (filteredTitles.isEmpty() == false) {
            String[] playTitles = new String[filteredTitles.size()];
            //Load Plays on List
            PlaysList.setListData(filteredTitles.toArray(playTitles));
        } else {
            //No Plays found
            String message = "<HTML><bODY><P>Δεν βρέθηκαν αποτελέσματα</P></BODY></HTML>";
            JOptionPane.showMessageDialog(this, message, "No Plays found", JOptionPane.ERROR_MESSAGE);
        }
        PlaysList.setCellRenderer(new DatabaseListCellRenderer());
    }//GEN-LAST:event_PlaySearchTextFieldActionPerformed

    private void ImportButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportButtonActionPerformed
        //File loading
        JFrame frame = (JFrame) SwingUtilities.getWindowAncestor(this);
        JFileChooser chooser = new JFileChooser();
        //chooser.showOpenDialog(null);
        chooser.setDialogTitle("Άνοιγμα αρχείου");
        int userSelection = chooser.showSaveDialog(frame);
        String s = null;

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File myFile = chooser.getSelectedFile();
            String path = chooser.getSelectedFile().getPath();

            try {
                //Load Play
                LoadPlayfromFile(myFile);
            } catch (IOException ex) {
                Logger.getLogger(LiteratureAnalyticsUI.class.getName()).log(Level.SEVERE, null, ex);
            }
            //Scrape Play and Load XML
            ScrapeandLoadXMLfromFile(myFile);
        }
    }//GEN-LAST:event_ImportButtonActionPerformed

    private void DatabasePlaysButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatabasePlaysButtonActionPerformed
        if (clicked == false) {
            if (dbTitles.isEmpty()) {
                //No Plays in the database
                String message = "<HTML><bODY><P>Δεν υπάρχουν Έργα στη Βάση Δεδομένων!</P></BODY></HTML>";
                JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.WARNING_MESSAGE);
            } else {
                //Show only Plays in the Database
                String[] playTitles = new String[dbTitles.size()];
                PlaysList.setListData(dbTitles.toArray(playTitles));
                clicked = true;
            }
        } else if (clicked == true) {
            //Show all Plays
            String[] playTitles = new String[titles.size()];
            PlaysList.setListData(titles.toArray(playTitles));
            clicked = false;
        }
        PlaysList.setCellRenderer(new DatabaseListCellRenderer());
    }//GEN-LAST:event_DatabasePlaysButtonActionPerformed

    private void SortPlaysButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SortPlaysButtonActionPerformed
        if (sorted == false) {
            ListModel model = PlaysList.getModel();
            String[] arrayTitles = new String[model.getSize()];
            for (int i = 0; i < arrayTitles.length; i++) {
                arrayTitles[i] = model.getElementAt(i).toString();
            }
            //Ascending order
            Arrays.sort(arrayTitles);
            PlaysList.setListData(arrayTitles);
            sorted = true;
        } else if (sorted == true) {
            ListModel model = PlaysList.getModel();
            String[] arrayTitles = new String[model.getSize()];
            for (int i = 0; i < arrayTitles.length; i++) {
                arrayTitles[i] = model.getElementAt(i).toString();
            }
            //Descending order
            Arrays.sort(arrayTitles, Collections.reverseOrder());
            PlaysList.setListData(arrayTitles);
            sorted = false;
        }
        PlaysList.setCellRenderer(new DatabaseListCellRenderer());
    }//GEN-LAST:event_SortPlaysButtonActionPerformed

    public class SelectedListCellRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
            if (isSelected) {
                //Set backgroung to Blue
                setBackground(Color.blue);
                //Set foreground to White
                setForeground(Color.white);
            }
            return this;
        }
    }

    public class HoveredListCellRenderer extends DefaultListCellRenderer {

        private final Color hoverColor = Color.cyan;
        private int hoverIndex = -1;
        private MouseAdapter handler;

        @Override
        public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            if (!isSelected) {
                setBackground(index == hoverIndex ? hoverColor : list.getBackground());
            } else {
                setBackground(Color.blue);
                setForeground(Color.white);
            }
            return this;
        }

        public MouseAdapter getHandler(JList list) {
            if (handler == null) {
                handler = new HoverMouseHandler(list);
            }
            return handler;
        }

        class HoverMouseHandler extends MouseAdapter {

            private final JList list;

            public HoverMouseHandler(JList list) {
                this.list = list;
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setHoverIndex(-1);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                int index = list.locationToIndex(e.getPoint());
                setHoverIndex(list.getCellBounds(index, index).contains(e.getPoint())
                        ? index : -1);
            }

            private void setHoverIndex(int index) {
                if (hoverIndex == index) {
                    return;
                }
                hoverIndex = index;
                list.repaint();
            }
        }

    }

    public class DatabaseListCellRenderer extends DefaultListCellRenderer {

        @Override
        public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
            Component c = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

            //System.out.println(value);
            for (int i = 0; i < dbTitles.size(); i++) {
                if (dbTitles.get(i).contains(value.toString())) {
                    c.setBackground(Color.green);
                    c.setForeground(Color.blue);
                }
            }
            return c;
        }
    }

    public ArrayList<String> CleanPlays(ArrayList<String> list) {

        for (int i = 0; i < list.size(); i++) {
            if (!list.get(i).contains("House") && !list.get(i).contains("Earnesr") && !list.get(i).contains("Pygmalion")
                    && !list.get(i).contains("Hamlet") && !list.get(i).contains("Rossum") && !list.get(i).contains("Ideal Husband")
                    && !list.get(i).contains("Post Office") && !list.get(i).contains("Midsummer")
                    && !list.get(i).contains("Work and Play") && !list.get(i).contains("PlayBoy")) {
                list.remove(list.get(i));
            }
            
            if (list.get(i).equals("The Complete Works of William Shakespeare")) {
                list.remove(list.get(i));
            }
            if (list.get(i).equals("Just So Stories")) {
                list.remove(list.get(i));
            }
            if (list.get(i).equals("Plays of Sophocles: Oedipus the King; Oedipus at Colonus; Antigone")) {
                list.remove(list.get(i));
            }
            if (list.get(i).equals("Plays")) {
                list.remove(list.get(i));
            }
            if (list.get(i).equals("Plays by Anton Chekhov, Second Series")) {
                list.remove(list.get(i));
            }
            if (list.get(i).equals("Work and Play in Girls' Schools")) {
                list.remove(list.get(i));
            }
            if (list.get(i).equals("Alice in Wonderland")) {
                list.remove(list.get(i));
            }
            if (list.get(i).equals("Macbeth")) {
                list.remove(list.get(i));
            }
            if (list.get(i).equals("Chitra, a Play in One Act")) {
                list.remove(list.get(i));
            }
            if (list.get(i).equals("Hamlet")) {
                list.remove(list.get(i));
            }
            
        }
        return list;
    }

    static public String getAttrValue(Node node, String attrName) {
        if (!node.hasAttributes()) {
            return "";
        }
        NamedNodeMap nmap = node.getAttributes();
        if (nmap == null) {
            return "";
        }
        Node n = nmap.getNamedItem(attrName);
        if (n == null) {
            return "";
        }
        return n.getNodeValue();
    }

    static private String getTextContent(Node parentNode, String childName) {
        NodeList nodelist = parentNode.getChildNodes();
        for (int i = 0; i < nodelist.getLength(); i++) {
            Node n = nodelist.item(i);
            String name = n.getNodeName();
            if (name != null && name.equals(childName)) {
                return n.getTextContent();
            }
        }
        return "";
    }

    public static ArrayList CrawlTitle(int level, String url, ArrayList<String> visited, ArrayList<String> t) {
        if (level <= 2) {
            org.jsoup.nodes.Document doc = (org.jsoup.nodes.Document) Request(url, visited);
            if (doc != null) {
                for (org.jsoup.nodes.Element link : doc.select("a[href]")) {
                    for (org.jsoup.nodes.Element play : doc.select("li.booklink").select("a")) {
                        //Get Title of Play
                        String playTitle = play.select(".title").text();
                        if (t.contains(playTitle) == false) {
                            t.add(playTitle);
                        }
                    }
                    String nextLink = link.absUrl("href");
                    if (visited.contains(nextLink) == false && link.text().equals("Next")) {
                        CrawlTitle(level, nextLink, visited, t);
                    }
                }
            }
        }
        return t;
    }

    public static ArrayList<String> CrawlURL(int level, String url, ArrayList<String> visited, String p, ArrayList<String> l) {
        if (level <= 2) {
            org.jsoup.nodes.Document doc = (org.jsoup.nodes.Document) Request(url, visited);
            if (doc != null && l.isEmpty()) {
                for (org.jsoup.nodes.Element link : doc.select("a[href]")) {
                    for (org.jsoup.nodes.Element play : doc.select("li.booklink").select("a")) {
                        String title = play.select("span.title").text();
                        if (title.equals(p)) {
                            //Get URL of Play
                            String playLink = play.absUrl("href");
                            l.add(playLink);
                        }
                    }
                    String nextLink = link.absUrl("href");
                    if (visited.contains(nextLink) == false && link.text().equals("Next")) {
                        System.out.println("Nextlink: " + nextLink);
                        CrawlURL(level, nextLink, visited, p, l);
                    }
                }
            }
        }
        return l;
    }

    public static String CrawlFileURL(String url, ArrayList<String> vis) {
        org.jsoup.nodes.Document doc = (org.jsoup.nodes.Document) Request(url, vis);

        String playFile = "";
        if (doc != null) {
            for (org.jsoup.nodes.Element link : doc.select("a[href]")) {
                if (link.text().contains("Read this book online: ")) {
                    playFile = link.absUrl("href");
                }
            }
        }
        return playFile;
    }

    public static org.jsoup.nodes.Document Request(String url, ArrayList<String> v) {
        try {
            org.jsoup.Connection con = Jsoup.connect(url);
            org.jsoup.nodes.Document doc = con.get();
            //Check if URL is ok to be visited
            if (con.response().statusCode() == 200) {
                v.add(url);
                return doc;
            }
            return null;
        } catch (IOException e) {
            return null;
        }
    }

    public void LoadPlay(String url) throws IOException {
        HTMLEditorKit kit = new HTMLEditorKit();
        HTMLEditorPane.setEditorKit(kit);
        Document document = kit.createDefaultDocument();
        HTMLEditorPane.setDocument(document);

        try {
            org.jsoup.nodes.Document doc = Jsoup.connect(url).get();
            String text = parseDocument(doc.html());
            //Load Play (HTML) in HTMLEditorPane
            HTMLEditorPane.setText(text);
            HTMLEditorPane.setVisible(true);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void LoadPlayfromFile(File f) throws IOException {
        HTMLEditorKit kit = new HTMLEditorKit();
        HTMLEditorPane.setEditorKit(kit);
        Document document = kit.createDefaultDocument();
        HTMLEditorPane.setDocument(document);

        String text = parseDocument(Jsoup.parse(f, "UTF-8", "").html());
        //Load Play (HTML) in HTMLEditorPane
        HTMLEditorPane.setText(text);
        HTMLEditorPane.setVisible(true);
    }

    public void ScrapeandLoadXML(String url) {
        //Enable Validation button
        XMLValidationButton.setEnabled(true);
        //Database Credentials
        String dbUrl = "jdbc:mysql://localhost/theatrical_plays?useUnicode=true&character_set_server=utf8mb4&characterEncoding=UTF-8";
        String username = "root";
        String password = "root123456";

        try {
            scrape = Jsoup.connect(url).get();

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.newDocument();

            //ROOT ELEMENT
            rootElement = document.createElement("Έργα");
            document.appendChild(rootElement);
            characterID = 0;

            //PLAY
            Play = document.createElement("Έργο");
            Title = document.createElement("Τίτλος");
            AuthorID = document.createElement("Συγγραφέας_ID");
            ReleaseDate = document.createElement("Ημερομηνία_Κυκλοφορίας");
            Genre = document.createElement("Είδος");
            PlayURL = document.createElement("URL");

            //PLAY TITLE
            Title.appendChild(document.createTextNode(playTitle));
            System.out.println("\n" + "Play Title: " + playTitle);
            rootElement.appendChild(Title);

            //PLAY ID
            org.jsoup.nodes.Element pid = scrape.select("body :contains(Release Date)").first();
            org.jsoup.nodes.Element prePid = null;
            //<PRE> FORMAT
            if (pid.tagName().equals("pre")) {
                prePid = pid;
            }
            String ID = pid.text().substring(pid.text().indexOf('[') + 1, pid.text().indexOf(']'));
            ID = ID.replaceAll("[a-zA-Z# ]", "");
            playID = Integer.parseInt(ID);
            Play.setAttribute("id", String.valueOf(playID));
            System.out.println("Play ID: " + ID);

            //AUTHOR ID
            org.jsoup.nodes.Element a = scrape.select("title").first();
            String author = null;

            if (a != null) {
                if (a.text().contains("by") || a.text().contains("By")) {
                    author = a.text().substring(a.text().indexOf(",") + 1, a.text().length()).trim();
                    if (author.contains(",")) {
                        author = author.substring(author.indexOf(",") + 1, author.length()).trim();
                    }
                    author = author.replace("By", "").replaceAll("by", "").replaceAll("\\.", "").trim();
                } else if (a.text().contains(",")) {
                    author = a.text().substring(a.text().indexOf(",") + 1, a.text().length()).trim();
                    author = author.substring(0, author.indexOf(",")).trim();
                }
            }
            try {
                //Create connection
                java.sql.Connection con = DriverManager.getConnection(dbUrl, username, password);

                PreparedStatement st = con.prepareStatement("SELECT Όνομα FROM συγγραφέας WHERE Όνομα = ?");
                st.setString(1, author);
                ResultSet rs = st.executeQuery();

                //Check if author Name already exists in the Database
                if (rs.next()) {
                    //System.out.println("Author: " + author + " already exists");
                    PreparedStatement authorExists = con.prepareStatement("SELECT Συγγραφέας FROM συγγραφέας WHERE Όνομα = ?");
                    authorExists.setString(1, author);
                    ResultSet authorRS = authorExists.executeQuery();

                    if (authorRS.next()) {
                        authorID = authorRS.getInt(1);
                        AuthorID.appendChild(document.createTextNode(String.valueOf(authorID)));;
                    }
                    //If author Name doesn't exist in the Database
                } else {
                    //System.out.println("Author " + author + " doesn't exist");
                    PreparedStatement authorNotExists = con.prepareStatement("SELECT COUNT(*) FROM συγγραφέας");
                    ResultSet authorRS = authorNotExists.executeQuery();

                    if (authorRS.next()) {
                        authorID = authorRS.getInt(1) + 1;
                        AuthorID.appendChild(document.createTextNode(String.valueOf(authorID)));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //RELEASE DATE
            if (prePid != null) {
                String s = "";
                for (int i = 0; i < prePid.text().length(); i++) {
                    char c = prePid.text().charAt(i);
                    s += c;
                    if (c == ']') {
                        String date = s.substring(s.lastIndexOf(':') + 1, s.indexOf('['));
                        date = date.replaceAll("^([^\\s]*)(\\s)", "").trim();
                        ReleaseDate.appendChild(document.createTextNode(date));
                        System.out.println("Release Date: " + date);
                        break;
                    }
                }
            } else {
                String date = pid.text().substring(pid.text().indexOf(':') + 1, pid.text().indexOf('['));
                date = date.replaceAll("^([^\\s]*)(\\s)", "").trim();
                ReleaseDate.appendChild(document.createTextNode(date));
                System.out.println("Release Date: " + date);
            }

            //GENRE
            if (Title.getTextContent().contains("Doll's House") || Title.getTextContent().contains("Hamlet")) {
                String genre = "Tragedy";
                Genre.appendChild(document.createTextNode(genre));
                System.out.println("Play Genre: " + genre);
            } else if (Title.getTextContent().contains("Being Earnest") || Title.getTextContent().contains("Midsummer Night's Dream")
                    || Title.getTextContent().contains("The Playboy")) {
                String genre = "Comedy";
                Genre.appendChild(document.createTextNode(genre));
                System.out.println("Play Genre: " + genre);
            } else if (Title.getTextContent().contains("Pygmalion") || Title.getTextContent().contains("Ideal Husband")) {
                String genre = "Romantic Comedy";
                Genre.appendChild(document.createTextNode(genre));
                System.out.println("Play Genre: " + genre);
            } else if (Title.getTextContent().contains("Rossum's Universal Robots")) {
                String genre = "Science Fiction";
                Genre.appendChild(document.createTextNode(genre));
                System.out.println("Play Genre: " + genre);
            } else if (Title.getTextContent().contains("Post Office") || Title.getTextContent().contains("A Leap For Freedom")) {
                String genre = "Drama";
                Genre.appendChild(document.createTextNode(genre));
                System.out.println("Play Genre: " + genre);
            }

            //URL
            PlayURL.appendChild(document.createTextNode(playURL));
            System.out.println("Play URL: " + playURL);

            //Append Child Elements
            Play.appendChild(Title);
            Play.appendChild(AuthorID);
            Play.appendChild(ReleaseDate);
            Play.appendChild(Genre);
            Play.appendChild(PlayURL);
            System.out.println("\n" + "------------------------------------------" + "\n");

            //AUTHOR
            Author = document.createElement("Συγγραφέας");
            AuthorName = document.createElement("Όνομα");
            AuthorBirthDate = document.createElement("Ημερομηνία_Γέννησης");
            AuthorBio = document.createElement("Βιογραφία");

            //AUTHOR ID
            Author.setAttribute("id", String.valueOf(authorID));
            System.out.println("Author ID: " + authorID);

            //AUTHOR NAME
            AuthorName.appendChild(document.createTextNode(author));
            System.out.println("Author Name: " + author);

            //AUTHOR BIRTH DATE & BIO
            if (author.contains("Shakespeare")) {
                AuthorBirthDate.appendChild(document.createTextNode("1564-04-26"));
                AuthorBio.appendChild(document.createTextNode("Ο Ουίλλιαμ Σαίξπηρ ήταν Άγγλος ποιητής και θεατρικός συγγραφέας. "
                        + "Θεωρείται ευρέως ως ο σημαντικότερος συγγραφέας που έγραψε "
                        + "στην αγγλική γλώσσα και ένας από τους σημαντικότερους "
                        + "δραματουργούς παγκοσμίως. Συχνά αποκαλείται "
                        + "εθνικός ποιητής της Αγγλίας και «Βάρδος του Έιβον»."));
            } else if (author.contains("Ibsen")) {
                AuthorBirthDate.appendChild(document.createTextNode("1828-03-20"));
                AuthorBio.appendChild(document.createTextNode("Ο Χένρικ Ίψεν ήταν Νορβηγός θεατρικός συγγραφέας και σκηνοθέτης. "
                        + "Ως ένας από τους ιδρυτές του μοντερνισμού στο θέατρο, "
                        + "ο Ιψεν αναφέρεται συχνά ως ο πατέρας του ρεαλισμού και "
                        + "ένας από τους πιο επιδραστικούς θεατρικούς συγγραφείς της εποχής του."));
            } else if (author.contains("Wilde")) {
                AuthorBirthDate.appendChild(document.createTextNode("1854-10-16"));
                AuthorBio.appendChild(document.createTextNode("Ο Όσκαρ Γουάιλντ ήταν Ιρλανδός μυθιστοριογράφος, ποιητής, "
                        + "δραματουργός και κριτικός. Έχοντας περάσει από διάφορα είδη "
                        + "γραπτού λόγου καθ' όλη τη δεκαετία του 1880, "
                        + "γεύτηκε τη δόξα ως θεατρικός συγγραφέας στο Λονδίνο "
                        + "στις αρχές της επόμενης δεκαετίας."));
            } else if (author.contains("Bernard Shaw")) {
                AuthorBirthDate.appendChild(document.createTextNode("1856-07-26"));
                AuthorBio.appendChild(document.createTextNode("Ο Tζορτζ Μπέρναρντ Σω ήταν Ιρλανδός στην καταγωγή και υπήρξε κριτικός, "
                        + "δραματουργός και θεατρικός συγγραφέας, "
                        + "που τιμήθηκε με το Νόμπελ Λογοτεχνίας το 1925."));
            } else if (author.contains("Capek")) {
                AuthorBirthDate.appendChild(document.createTextNode("1890-01-09"));
                AuthorBio.appendChild(document.createTextNode("Ο Κάρελ Τσάπεκ ήταν Τσέχος μυθιστοριογράφος, διηγηματογράφος, "
                        + "και θεατρικός συγγραφέας, γεννημένος στο "
                        + "Μάλε Σβατονόβιτσε της ανατολικής Βοημίας το 1890."));
            } else if (author.contains("Tagore")) {
                AuthorBirthDate.appendChild(document.createTextNode("1861-05-07"));
                AuthorBio.appendChild(document.createTextNode("Ο Ραμπιντρανάθ Ταγκόρ, ήταν Ινδός συνθέτης, ζωγράφος, "
                        + "συγγραφέας και φιλόσοφος, του οποίου το έργο είχε σημαντική επίδραση "
                        + "στη λογοτεχνία και τη μουσική της Βεγγάλης στα τέλη του 19ου και τις αρχές "
                        + "του 20ού αιώνα και στον οποίο απονεμήθηκε το Βραβείο Νόμπελ Λογοτεχνίας το 1913."));
            } else if (author.contains("Wells Brown")) {
                AuthorBirthDate.appendChild(document.createTextNode("1815-03-15"));
                AuthorBio.appendChild(document.createTextNode("Ο Γουίλιαμ Γουέλς Μπράουν ήταν εξέχων αφρικανικός-αμερικανικός "
                        + "καθηγητής καταργητών, μυθιστοριογράφος, θεατρικός συγγραφέας και ιστορικός στις Ηνωμένες Πολιτείες. "
                        + "Γεννημένος σε δουλεία στο Montgomery County, Κεντάκι, "
                        + "κοντά στην πόλη του Mount Sterling, ο Μπράουν δραπέτευσε στο Οχάιο το 1834 σε ηλικία 19 ετών."));
            } else if (author.contains("Synge")) {
                AuthorBirthDate.appendChild(document.createTextNode("1871-04-16"));
                AuthorBio.appendChild(document.createTextNode("Ο Edmund John Millington Synge ήταν ιρλανδός θεατρικός συγγραφέας, ποιητής, "
                        + "συγγραφέας, συλλέκτης λαογραφίας και βασική προσωπικότητα  "
                        + "στην ιρλανδική λογοτεχνική αναβίωση."));
            } else {
                AuthorBirthDate.appendChild(document.createTextNode("????-??-??"));
                AuthorBio.appendChild(document.createTextNode("????"));
            }
            //Append Child Elements
            Author.appendChild(AuthorName);
            Author.appendChild(AuthorBirthDate);
            Author.appendChild(AuthorBio);
            Play.appendChild(Author);
            System.out.println("\n" + "------------------------------------------" + "\n");

            //CONTENTS
            Contents = document.createElement("Περιεχόμενα");

            //<A HREF> IN <TABLE> ELEMENT
            org.jsoup.nodes.Element contentsTable = scrape.select("table").first();
            if (contentsTable != null) {
                for (org.jsoup.nodes.Element contents : contentsTable.select("a")) {
                    Contents.appendChild(document.createTextNode(contents.text() + " "));
                    System.out.println("Play Contents: " + contents.text());
                    Play.appendChild(Contents);
                }
            }
            //<A HREF> INSIDE <P> FORMAT
            for (org.jsoup.nodes.Element p : scrape.select("p")) {
                for (org.jsoup.nodes.Element contents : p.select("a")) {
                    if (contents != null && contents.text().contains("[a-zA-Z]")) {
                        Contents.appendChild(document.createTextNode(contents.text().trim() + " "));
                        System.out.println("Play Contents: " + contents.text().trim());
                        Play.appendChild(Contents);
                    }
                }
            }
            //<A HREF> INSIDE <DIV CLASS="PH4"> FORMAT
            for (org.jsoup.nodes.Element p : scrape.select("div.ph4")) {
                for (org.jsoup.nodes.Element contents : p.select("a")) {
                    Contents.appendChild(document.createTextNode(contents.text() + " "));
                    System.out.println("Play Contents: " + contents.text());
                    Play.appendChild(Contents);
                }
            }
            //THE SCENES OF THE PLAY FORMAT
            org.jsoup.nodes.Element scenesofPlay = scrape.select("body :contains(THE SCENES OF THE PLAY)").first();
            if (scenesofPlay != null) {
                scenesofPlay = scenesofPlay.nextElementSibling();
                //<P> ELEMENTS ONE AFTER ANOTHER FORMAT
                while (scenesofPlay.tagName().equals("p")) {
                    org.jsoup.nodes.Element contents = scenesofPlay;
                    Contents.appendChild(document.createTextNode(contents.text() + "\n"));
                    System.out.println("Play Contents: " + contents.text());
                    scenesofPlay = scenesofPlay.nextElementSibling();
                }
                Play.appendChild(Contents);
            }
            //CONTENTS IN <H2> FORMAT
            org.jsoup.nodes.Element contents = scrape.select("body :contains(Contents)").first();
            if (contents != null && contents.tagName().equals("h2")) {
                contents = contents.nextElementSibling();
                //ALL CONTENTS IN ONE <P> ELEMENT FORMAT
                if (contents.tagName().equals("p")) {
                    String content = contents.text().trim();
                    Contents.appendChild(document.createTextNode(content + "\n"));
                    System.out.println("Play Contents: " + content);
                }
                Play.appendChild(Contents);
            }
            //THE SCENES FORMAT
            org.jsoup.nodes.Element theScenes = scrape.select("body :contains(THE SCENES)").first();
            if (theScenes != null) {
                //<TABLE> FORMAT
                if (theScenes.tagName().equals("table")) {
                    for (org.jsoup.nodes.Element c : theScenes.select("tr")) {
                        Contents.appendChild(document.createTextNode(c.text().trim() + " "));
                        System.out.println("Play Contents: " + c.text().trim());
                    }
                }
            }
            Play.appendChild(Contents);
            System.out.println("\n" + "------------------------------------------" + "\n");

            //INTRODUCTION
            Introduction = document.createElement("Εισαγωγή");

            //STORY OF THE PLAY FORMAT
            org.jsoup.nodes.Element storyofPlay = scrape.select("body :contains(STORY OF THE PLAY)").first();
            if (storyofPlay != null) {
                storyofPlay = storyofPlay.nextElementSibling();
                //<P> ELEMENTS FORMAT
                while (storyofPlay.tagName().equals("p")) {
                    String introduction = storyofPlay.text().replaceAll("\\[", "").replaceAll("\\]", "");
                    Introduction.appendChild(document.createTextNode(introduction));
                    System.out.println("Introduction of Play: " + "\n" + introduction);
                    storyofPlay = storyofPlay.nextElementSibling();
                }
                Play.appendChild(Introduction);
            }
            //AUTHOR’S PREFACE FORMAT
            org.jsoup.nodes.Element authorPreface = scrape.select("body :contains(AUTHOR’S PREFACE)").first();
            if (authorPreface != null) {
                authorPreface = authorPreface.nextElementSibling();
                //<P> ELEMENTS FORMAT
                while (!authorPreface.text().contains("[")) {
                    if (authorPreface.tagName().equals("p")) {
                        String introduction = authorPreface.text();
                        Introduction.appendChild(document.createTextNode(introduction));
                        System.out.println("Introduction of Play: " + "\n" + introduction);
                    }
                    authorPreface = authorPreface.nextElementSibling();
                }
                Play.appendChild(Introduction);
            } else {
                //PREFACE FORMAT
                org.jsoup.nodes.Element preface = scrape.select("body :contains(PREFACE)").last();
                if (preface != null && preface.tagName().equals("h2")) {
                    preface = preface.nextElementSibling();
                    //<P> ELEMENTS FORMAT
                    if (preface.tagName().equals("p")) {
                        String introduction = preface.text();
                        Introduction.appendChild(document.createTextNode(introduction));
                        System.out.println("Introduction of Play: " + "\n" + introduction);
                        Play.appendChild(Introduction);
                    }
                }
            }
            System.out.println("\n" + "------------------------------------------" + "\n");

            //CHARACTERS
            Characters = document.createElement("Χαρακτήρες");

            //CHARACTERS (IN ORDER OF APPEARENCE) FORMAT
            org.jsoup.nodes.Element chars = scrape.select("body :contains(CHARACTERS (in order of appearance))").first();
            if (chars != null) {
                chars = chars.nextElementSibling();
                //<TABLE> FORMAT
                for (org.jsoup.nodes.Element c : chars.select("span")) {
                    String characters = c.text().replaceAll("\\[", "").replaceAll("\\]", "");
                    Characters.appendChild(document.createTextNode(characters));
                    System.out.println("Characters of Play: " + characters);
                    Play.appendChild(Characters);
                }
            }
            //DRAMATIS PERSONAE FORMAT
            org.jsoup.nodes.Element dramatisPersonae = scrape.select("body :contains(Dramatis Person)").first();
            if (dramatisPersonae != null) {
                dramatisPersonae = dramatisPersonae.nextElementSibling();
                //<P> ELEMENTS FORMAT
                if (dramatisPersonae.tagName().equals("p")) {
                    String characters = dramatisPersonae.text().replaceAll("\\[", "").replaceAll("\\]", "");
                    Characters.appendChild(document.createTextNode(characters));
                    System.out.println("Characters of Play: " + "\n" + characters);
                    Play.appendChild(Characters);
                }
                if (dramatisPersonae.tagName().equals("ul")) {
                    String characters = dramatisPersonae.text().replaceAll("\\[", "").replaceAll("\\]", "");
                    Characters.appendChild(document.createTextNode(characters));
                    System.out.println("Characters of Play: " + "\n" + characters);
                    Play.appendChild(Characters);
                }
            }
            //THE PERSONS OF THE PLAY FORMAT
            org.jsoup.nodes.Element personsofPlay = scrape.select("body :contains(THE PERSONS OF THE PLAY)").first();
            if (personsofPlay != null) {
                personsofPlay = personsofPlay.nextElementSibling();
                //<P> ELEMENTS ONE AFTER ANOTHER FORMAT
                while (personsofPlay.tagName().equals("p")) {
                    org.jsoup.nodes.Element characters = personsofPlay;
                    Characters.appendChild(document.createTextNode(characters.text() + "\n"));
                    System.out.println("Characters of Play: " + "\n" + characters);
                    personsofPlay = personsofPlay.nextElementSibling();
                }
                Play.appendChild(Characters);
            }
            //THE PERSONS IN THE PLAY FORMAT
            org.jsoup.nodes.Element personsinPlay = scrape.select("body :contains(THE PERSONS IN THE PLAY)").first();
            if (personsinPlay != null) {
                personsinPlay = personsinPlay.nextElementSibling();
                //ALL CHARACTERS IN ONE <P> FORMAT
                if (personsinPlay.tagName().equals("p")) {
                    String characters = personsinPlay.text();
                    Characters.appendChild(document.createTextNode(characters));
                    System.out.println("Characters of Play: " + "\n" + characters);
                    Play.appendChild(Characters);
                }
            }
            //PERSONS FORMAT
            org.jsoup.nodes.Element persons = scrape.select("body :contains(PERSONS)").last();
            if (persons != null && persons.tagName().equals("h2")) {
                persons = persons.nextElementSibling();
                //ALL CHARACTERS IN ONE <P> FORMAT
                if (persons.tagName().equals("p")) {
                    String characters = persons.text();
                    Characters.appendChild(document.createTextNode(characters));
                    System.out.println("Characters of Play: " + "\n" + characters);
                    Play.appendChild(Characters);
                }
            }
            //CHARACTERS REPRESENTED FORMAT
            org.jsoup.nodes.Element represented = scrape.select("body :contains(CHARACTERS REPRESENTED)").first();
            if (represented != null) {
                represented = represented.nextElementSibling();
                //ALL CHARACTERS IN ONE <UL> FORMAT
                if (represented.tagName().equals("ul")) {
                    String characters = represented.text();
                    Characters.appendChild(document.createTextNode(characters));
                    System.out.println("Characters of Play: " + "\n" + characters);
                    Play.appendChild(Characters);
                }
            }
            System.out.println("\n" + "------------------------------------------" + "\n");

            //MAIN PLAY
            actNumber = 0;
            sceneNumber = 0;
            scenes = 0;

            //<DIV CLASS="CHAPTER"> INSIDE ANOTHER <DIV CLASS="CHAPTER"> FOR EACH ACT FORMAT
            org.jsoup.nodes.Element nestedChapterPerAct = scrape.select("h2#act1").first();
            //<DIV CLASS="CHAPTER"> PER ACT FORMAT
            org.jsoup.nodes.Element chapterPerAct = scrape.selectFirst("div.chapter :contains(ACT I)");
            //<DIV CLASS="CHAPTER"> PER ACT FORMAT (ACT ONE)
            org.jsoup.nodes.Element chapterPerActOne = scrape.selectFirst("div.chapter :contains(ACT ONE)");
            //FIRST ACT FORMAT
            org.jsoup.nodes.Element firstAct = scrape.select("body :contains(FIRST ACT)").first();
            //ACT I THAT IS INSIDE <H2> FORMAT
            org.jsoup.nodes.Element actI = scrape.select("h2 :contains(ACT I)").first();
            //ACT I THAT IS DIRECTLY <H2> FORMAT
            //org.jsoup.nodes.Element actOwn = scrape.select("h2:containsOwn(ACT I)").first();
            //ACT I THAT IS <H2> FORMAT
            org.jsoup.nodes.Element actH2 = scrape.select("body :contains(ACT I)").first();

            if (nestedChapterPerAct != null) {
                System.out.println("\n<DIV CLASS=\"CHAPTER\"> INSIDE ANOTHER <DIV CLASS=\"CHAPTER\"> FOR EACH ACT FORMAT \n");
                org.jsoup.nodes.Element act = nestedChapterPerAct;

                while (act != null) {
                    if (act.hasAttr("id")) {
                        //ACT
                        Act = document.createElement("Πράξη");
                        actNumber++;
                        System.out.println("ACT " + actNumber + "\n");
                        Act.setAttribute("Νούμερο", String.valueOf(actNumber));
                    }
                    if (act.tagName().equals("p")) {
                        //STAGE DIRECTIONS
                        if (act.hasClass("noindent") || act.hasClass("stage")) {
                            StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                            StageDirections.appendChild(document.createTextNode(act.text().replaceAll("\\[", "").replaceAll("\\]", "")));
                            System.out.println("Stage Directions: " + act.text() + "\n");
                            Act.appendChild(StageDirections);
                        } else if (act.hasClass("dialog")) {
                            //CHARACTER
                            Character = document.createElement("Χαρακτήρας");
                            //CHARACTER NAME
                            CharacterName = document.createElement("Όνομα");
                            String fix = act.text().replaceAll("THE DAUGHTER", "THE DAUGHTER.").replaceAll("THE MOTHER", "THE MOTHER.")
                                    .replaceAll("A BYSTANDER", "A BYSTANDER.").replaceAll("THE FLOWER GIRL", "THE FLOWER GIRL.")
                                    .replaceAll("THE BYSTANDER", "THE BYSTANDER.").replaceAll("THE NOTE TAKER", "THE NOTE TAKER.")
                                    .replaceAll("THE BYSTANDERS GENERALLY", "THE BYSTANDERS GENERALLY.").replaceAll("THE GENTLEMAN", "THE GENTLEMAN.")
                                    .replaceAll("A SARCASTIC BYSTANDER", "A SARCASTIC BYSTANDER.").replaceAll("THE SARCASTIC BYSTANDER", "THE SARCASTIC BYSTANDER.")
                                    .replaceAll("THE SARCASTIC ONE", "THE SARCASTIC ONE.").replaceAll("SEVERAL BYSTANDERS", "SEVERAL BYSTANDERS.")
                                    .replaceAll("PICKERING", "PICKERING.").replaceAll("HIGGINS", "HIGGINS.").replaceAll("FREDDY", "FREDDY.")
                                    .replaceAll("PEARCE", "PEARCE.").replaceAll("LIZA", "LIZA.")
                                    .replaceAll("DOOLITTLE", "DOOLITTLE.").replaceAll("EYNSFORD HILL", "EYNSFORD HILL.")
                                    .replaceAll("Miss EYNSFORD HILL", "MISS EYNSFORD HILL").replaceAll("MISS EYNSFORD HILL", "MRS. EYNSFORD HILL.")
                                    .replaceAll("THE PARLOR-MAID", "THE PARLOR-MAID.").replaceAll("CLARA", "CLARA.")
                                    .replaceAll("THE BYSTANDER.", "A BYSTANDER.").replaceAll("THE GENTLEMEN.", "THE GENTLEMAN.")
                                    .replaceAll("THE SARCASTIC BYSTANDER", "A SARCASTIC BYSTANDER").replaceAll("THE SARCASTIC ONE", "A SARCASTIC BYSTANDER")
                                    .replaceAll("MRS.", "MRS");
                            fix = fix.replaceAll("\\..", "\\.");
                            if (act.text().contains("Liza opens her mouth")) {
                                fix = "LIZA. " + act.text();
                            } else if (act.text().contains("He hurries to the door")) {
                                fix = "DOOLITTLE. " + act.text();
                            } else if (act.text().contains("They are interrupted by the")) {
                                fix = "THE PARLOR-MAID. " + act.text();
                            } else if (act.text().contains("Pickering gasps and sits down")) {
                                fix = "PICKERING. " + act.text();
                            }
                            String name = fix.substring(0, fix.indexOf(".") + 1).replaceAll("\\.", "");
                            System.out.println("Character: " + name + "\n");
                            if (charList.contains(name)) {
                                id = charList.indexOf(name) + 1;
                                Character.setAttribute("id", String.valueOf(id));
                            } else {
                                charList.add(name);
                                characterID++;
                                Character.setAttribute("id", String.valueOf(characterID));
                            }
                            CharacterName.appendChild(document.createTextNode(name));
                            Character.appendChild(CharacterName);
                            Act.appendChild(Character);

                            String str = fix.substring(fix.indexOf(".") + 1, fix.length()).trim();
                            str = str.replaceAll("\\].", "\\.]");
                            if (str.contains("[")) {
                                //Split the string into Stage directions and Speech
                                String[] parts = str.split("(?<=])|(?=\\[)");

                                for (String s : parts) {
                                    //CHARACTER STAGE DIRECTIONS
                                    if (s.contains("[")) {
                                        s = s.replaceAll("\\[", "").replaceAll("\\]", "");
                                        System.out.println("Stage Directions: " + s + "\n");
                                        StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                                        StageDirections.appendChild(document.createTextNode(s));
                                        Character.appendChild(StageDirections);
                                    } else {
                                        //CAHARACTER SPEECH
                                        System.out.println("Speech: " + s + "\n");
                                        Speech = document.createElement("Λόγος");
                                        Speech.appendChild(document.createTextNode(s));
                                        Character.appendChild(Speech);
                                        Act.appendChild(Character);
                                    }
                                }
                            } else {
                                //CHARACTER SPEECH ONLY
                                System.out.println("Speech: " + str + "\n");
                                Speech = document.createElement("Λόγος");
                                Speech.appendChild(document.createTextNode(str));
                                Character.appendChild(Speech);
                                Act.appendChild(Character);
                            }
                        }
                    }
                    Play.appendChild(Act);
                    act = act.nextElementSibling();
                }
            } else if (chapterPerAct != null) {
                System.out.println("\n<DIV CLASS=\"CHAPTER\"> PER ACT FORMAT \n");
                org.jsoup.nodes.Element next = chapterPerAct.nextElementSibling();

                //<DIV CLASS="CHAPTER"> PER ACT FORMAT (ELEMENTS ARE WITHIN THE <DIV CLASS="CHAPTER">)
                if (next != null) {
                    System.out.println("ELEMENTS ARE WITHIN THE <DIV CLASS=\"CHAPTER\">");
                    org.jsoup.nodes.Element act = chapterPerAct;
                    org.jsoup.nodes.Element div = chapterPerAct.parent();

                    while (div != null && div.hasClass("chapter")) {
                        //Get 1st child element
                        act = div.child(0);
                        //ACT
                        if (act.text().contains("ACT")) {
                            Act = document.createElement("Πράξη");
                            actNumber++;
                            System.out.println("ACT " + actNumber + "\n");
                            Act.setAttribute("Νούμερο", String.valueOf(actNumber));
                            sceneNumber = 0;
                        } else {
                            act = act.nextElementSibling();
                            if (act.text().contains("ACT")) {
                                Act = document.createElement("Πράξη");
                                actNumber++;
                                System.out.println("ACT " + actNumber + "\n");
                                Act.setAttribute("Νούμερο", String.valueOf(actNumber));
                                sceneNumber = 0;
                            }
                        }
                        if (!act.text().contains("ACT")) {
                            break;
                        }

                        //Until last element 
                        while (act != null && !act.text().contains("THE PLAYBOY OF")) {
                            //SCENE
                            if (act.text().contains("SCENE")) {
                                Scene = document.createElement("Σκηνή");
                                sceneNumber++;
                                System.out.println("Scene " + sceneNumber + "\n");
                                Scene.setAttribute("Νούμερο", String.valueOf(sceneNumber));
                                scenes++;
                            }
                            //<P> ELEMENT
                            if (act.tagName().equals("p") && act.hasText()) {
                                //STAGE DIRECTIONS
                                if (act.hasClass("scenedesc") || act.hasClass("right") || act.hasClass("center")) {
                                    StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                                    StageDirections.appendChild(document.createTextNode(act.text().replaceAll("\\[", "").replaceAll("\\]", "")));
                                    System.out.println("Stage Directions: " + act.text() + "\n");
                                    Scene.appendChild(StageDirections);
                                } else if ((!act.html().contains("<br>"))) {
                                    StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                                    StageDirections.appendChild(document.createTextNode(act.text().replaceAll("\\[", "").replaceAll("\\]", "")));
                                    System.out.println("StageDirections: " + act.text() + "\n");
                                    Scene.appendChild(StageDirections);
                                } else {
                                    //CHARACTER
                                    Character = document.createElement("Χαρακτήρας");
                                    //CHARACTER NAME
                                    CharacterName = document.createElement("Όνομα");
                                    String fix = act.text().replaceAll("BARNARDO", "BARNARDO.").replaceAll("But, soft,", "HORATIO. But, soft,")
                                            .replaceAll("Stop it, Marcellus", "HORATIO. Stop it, Marcellus")
                                            .replaceAll("And now, Laertes", "KING. And now, Laertes").replaceAll("Welcome, my", "KING. Welcome, my")
                                            .replaceAll("Mar. and BARNARDO.", "MARCELLUS and BARNARDO.").replaceAll("Both.", "BOTH.")
                                            .replaceAll("My father’s spirit", "HAMLET. My father’s spirit").replaceAll("A double blessing", "LAERTES. A double blessing")
                                            .replaceAll("And these few", "POLONIUS. And these few").replaceAll("By heaven, I’ll make", "HAMLET. By heaven, I’ll make")
                                            .replaceAll("So, uncle", "HAMLET. So, uncle").replaceAll("He tells me", "KING. He tells me").replaceAll("All. ", "ALL. ")
                                            .replaceAll("’Tis now the", "HAMLET. ’Tis now the").replaceAll("O, my offence", "KING. O, my offence")
                                            .replaceAll("Friends both", "KING. Friends both").replaceAll("Come, Gertrude", "KING. Come, Gertrude")
                                            .replaceAll("And England,", "KING. And England,").replaceAll("How all occasions", "HAMLET. How all occasions")
                                            .replaceAll("To my sick", "QUEEN. To my sick").replaceAll("Then up", "OPHELIA. Then up").replaceAll("Quoth she", "OPHELIA. Quoth she")
                                            .replaceAll("O, this is the", "KING. O, this is the").replaceAll("Danes.", "DANES.").replaceAll("O heat", "LAERTES. O heat")
                                            .replaceAll("His beard was as", "OPHELIA. His beard was as").replaceAll("I do not know from", "HORATIO. I do not know from")
                                            .replaceAll("Come, I will", "HORATIO. Come, I will").replaceAll("In youth", "FIRST CLOWN. In youth")
                                            .replaceAll("The Queen, the", "HAMLET. The Queen, the").replaceAll("\\[Reads.\\] ‘High", "KING. \\[Reads.\\] ‘High")
                                            .replaceAll("Come. Another", "HAMLET. Come. Another").replaceAll("\\[To Laertes\\]", "KING. \\[To Laertes\\]")
                                            .replaceAll("Dost thou hear me", "HAMLET. Dost thou hear me").replaceAll("How now, Ophelia,", "POLONIUS. How now, Ophelia,")
                                            .replaceAll("How now, my lord", "HAMLET. How now, my lord").replaceAll("How now? What news?", "KING. How now? What news?")
                                            .replaceAll("How now? What hath", "KING. How now? What hath").replaceAll("Save me and", "HAMLET. Save me and")
                                            .replaceAll("What should this mean", "KING. What should this mean").replaceAll("SARAH", "SARAH.").replaceAll("SUSAN", "SUSAN.")
                                            .replaceAll("There we lay", "MICHAEL. There we lay").replaceAll("SARA.", "SARAH.").replaceAll("SARA TANSEY.", "SARAH.")
                                            .replaceAll("SHAWN KEOGH.", "SHAWN.").replaceAll("DOCTOR RANK.", "RANK.").replaceAll("THE CHILDREN.", "CHILDREN.");
                                    String name = fix.substring(0, fix.indexOf(".") + 1).replaceAll("\\.", "");
                                    System.out.println("Character: " + name + "\n");
                                    if (charList.contains(name)) {
                                        id = charList.indexOf(name) + 1;
                                        Character.setAttribute("id", String.valueOf(id));
                                    } else {
                                        charList.add(name);
                                        characterID++;
                                        Character.setAttribute("id", String.valueOf(characterID));
                                    }
                                    CharacterName.appendChild(document.createTextNode(name));
                                    Character.appendChild(CharacterName);
                                    Scene.appendChild(Character);

                                    String str = act.text().substring(act.text().indexOf(".") + 1, act.text().length()).trim();
                                    str = str.replaceAll("\\(", "\\[").replaceAll("\\)", "\\]").trim();
                                    if (str.contains("[")) {
                                        //Split the string into Stage directions and Speech
                                        String[] parts = str.split("(?<=])|(?=\\[)");

                                        for (String s : parts) {
                                            //CHARACTER STAGE DIRECTIONS
                                            if (s.contains("[")) {
                                                s = s.replaceAll("\\[", "").replaceAll("\\]", "");
                                                System.out.println("Stage Directions: " + s + "\n");
                                                StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                                                StageDirections.appendChild(document.createTextNode(s));
                                                Character.appendChild(StageDirections);
                                            } else {
                                                //CAHARACTER SPEECH
                                                if (s.startsWith(". ")) {
                                                    s = s.replaceAll("\\. ", "").trim();
                                                }
                                                s = s.trim();
                                                System.out.println("Speech: " + s + "\n");
                                                Speech = document.createElement("Λόγος");
                                                Speech.appendChild(document.createTextNode(s));
                                                Character.appendChild(Speech);
                                                Scene.appendChild(Character);
                                            }
                                        }
                                    } else {
                                        //CHARACTER SPEECH ONLY
                                        System.out.println("Speech: " + str.trim() + "\n");
                                        Speech = document.createElement("Λόγος");
                                        Speech.appendChild(document.createTextNode(str.trim()));
                                        Character.appendChild(Speech);
                                        Scene.appendChild(Character);
                                    }
                                }
                                Act.appendChild(Scene);
                            }
                            act = act.nextElementSibling();
                        }
                        Play.appendChild(Act);
                        div = div.nextElementSibling();
                    }
                } //<DIV CLASS="CHAPTER"> PER ACT FORMAT (ELEMENTS ARE NOT WITHIN THE <DIV CLASS="CHAPTER">)
                else {
                    System.out.println("ELEMENTS ARE NOT WITHIN THE <DIV CLASS=\"CHAPTER\">");
                    org.jsoup.nodes.Element act = chapterPerAct.parent();

                    while (!act.text().contains("PROPERTY LIST") && !act.text().contains("THE END")) {
                        //ACT
                        if (act.hasClass("chapter")) {
                            Act = document.createElement("Πράξη");
                            actNumber++;
                            System.out.println("ACT " + actNumber + "\n");
                            Act.setAttribute("Νούμερο", String.valueOf(actNumber));
                            sceneNumber = 0;
                        }
                        //SCENE
                        if (act.text().contains("Scene ")) {
                            Scene = document.createElement("Σκηνή");
                            sceneNumber++;
                            System.out.println("Scene " + sceneNumber + "\n");
                            Scene.setAttribute("Νούμερο", String.valueOf(sceneNumber));
                            scenes++;
                        }
                        //STAGE DIRECTIONS
                        if (act.tagName().equals("div") && act.hasClass("scene")) {
                            StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                            StageDirections.appendChild(document.createTextNode(act.text().replaceAll("\\[", "").replaceAll("\\]", "")));
                            System.out.println("Stage Directions: " + act.text() + "\n");
                            if (Scene != null) {
                                Scene.appendChild(StageDirections);
                            } else {
                                Act.appendChild(StageDirections);
                            }
                        }
                        //STAGE DIRECTIONS
                        if (act.tagName().equals("blockquote")) {
                            StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                            StageDirections.appendChild(document.createTextNode(act.text().replaceAll("\\[", "").replaceAll("\\]", "")));
                            System.out.println("Stage Directions: " + act.text() + "\n");
                            //Act.appendChild(StageDirections);
                            if (Scene != null) {
                                Scene.appendChild(StageDirections);
                            } else {
                                Act.appendChild(StageDirections);
                            }
                        }
                        if (act.tagName().equals("table")) {
                            org.jsoup.nodes.Element tr = act.select("tr").first();
                            System.out.println("First tr: " + tr);

                            while (tr != null) {
                                //CHARACTER
                                Character = document.createElement("Χαρακτήρας");
                                //CHARACTER NAME
                                CharacterName = document.createElement("Όνομα");
                                String fix = tr.text().replaceAll("Dr.", "Dr");
                                String name = fix.substring(0, fix.indexOf(".") + 1).replaceAll("\\.", "");
                                System.out.println("Character: " + name + "\n");
                                if (charList.contains(name)) {
                                    id = charList.indexOf(name) + 1;
                                    Character.setAttribute("id", String.valueOf(id));
                                } else {
                                    charList.add(name);
                                    characterID++;
                                    Character.setAttribute("id", String.valueOf(characterID));
                                }
                                CharacterName.appendChild(document.createTextNode(name));
                                Character.appendChild(CharacterName);
                                //Act.appendChild(Character);
                                if (Scene != null) {
                                    Scene.appendChild(Character);
                                } else {
                                    Act.appendChild(Character);
                                }

                                String str = fix.substring(fix.indexOf(".") + 1, fix.length()).trim();
                                str = str.replaceAll("\\(", "\\[").replaceAll("\\)", "\\]");
                                if (str.contains("[")) {
                                    //Split the string into Stage directions and Speech
                                    String[] parts = str.split("(?<=])|(?=\\[)");

                                    for (String s : parts) {
                                        //CHARACTER STAGE DIRECTIONS
                                        if (s.contains("[")) {
                                            s = s.replaceAll("\\[", "").replaceAll("\\]", "").trim();
                                            System.out.println("Stage Directions: " + s + "\n");
                                            StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                                            StageDirections.appendChild(document.createTextNode(s));
                                            Character.appendChild(StageDirections);
                                        } else {
                                            //CAHARACTER SPEECH
                                            System.out.println("Speech: " + s + "\n");
                                            Speech = document.createElement("Λόγος");
                                            Speech.appendChild(document.createTextNode(s));
                                            Character.appendChild(Speech);
                                            //Act.appendChild(Character);
                                            if (Scene != null) {
                                                Scene.appendChild(Character);
                                            } else {
                                                Act.appendChild(Character);
                                            }
                                        }
                                    }
                                } else {
                                    //CHARACTER SPEECH ONLY
                                    System.out.println("Speech: " + str + "\n");
                                    Speech = document.createElement("Λόγος");
                                    Speech.appendChild(document.createTextNode(str));
                                    Character.appendChild(Speech);
                                    //Act.appendChild(Character);
                                    if (Scene != null) {
                                        Scene.appendChild(Character);
                                    } else {
                                        Act.appendChild(Character);
                                    }
                                }
                                tr = tr.nextElementSibling();
                            }
                        }
                        if (act.tagName().equals("p")) {
                            //STAGE DIRECTIONS
                            if (act.hasClass("center") || act.hasClass("right") || act.hasClass("enter") || act.hasClass("exit") || act.hasClass("direction")) {
                                StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                                StageDirections.appendChild(document.createTextNode(act.text().replaceAll("\\[", "").replaceAll("\\]", "")));
                                System.out.println("Stage Directions: " + act.text() + "\n");
                                //Act.appendChild(StageDirections);
                                if (Scene != null) {
                                    Scene.appendChild(StageDirections);
                                } else {
                                    Act.appendChild(StageDirections);
                                }
                            } else if (act.hasText() && !act.text().contains("[") && !act.hasClass("bottom-three")) {
                                //CHARACTER
                                Character = document.createElement("Χαρακτήρας");
                                //CHARACTER NAME
                                CharacterName = document.createElement("Όνομα");
                                String fix = act.text().replaceAll("Helena", "Helena.").replaceAll("Gall", "Gall.").replaceAll("Dr.", "Dr")
                                        .replaceAll("Mrs.", "Mrs").replaceAll("Mr.", "Mr").replaceAll("We mistresses", "Mrs G. We mistresses")
                                        .replaceAll("I am to have", "Mrs G. I am to have").replaceAll("I am glad to see you,", "Glen. I am glad to see you,")
                                        .replaceAll("Oh, how happy", "Melinda. Oh, how happy").replaceAll("But she must be sure", "Mr P. But she must be sure")
                                        .replaceAll("Why, how do you do, Squire", "Walk. Why, how do you do, Squire").replaceAll("Why, how do you do, Mr Pinchen", "Walk. Why, how do you do, Mr Pinchen")
                                        .replaceAll("Ah! my dear, I am glad you’ve come, I’ve been", "Dr G. Ah! my dear, I am glad you’ve come, I’ve been")
                                        .replaceAll("Ah! my dear, I am glad you’ve come.", "Dr Gaines. Ah! my dear, I am glad you’ve come.")
                                        .replaceAll("That man is enough", "Mrs Gaines. That man is enough").replaceAll("Good ebenin", "Cato. Good ebenin")
                                        .replaceAll("Dr Gaines, (in a low voice)", "Dr Gaines. (in a low voice)").replaceAll("I am glad that the Colonel", "Mrs G. I am glad that the Colonel")
                                        .replaceAll("Hannah needn’t", "Cato. Hannah needn’t").replaceAll("Walk in, sir", "Hannah. Walk in, sir")
                                        .replaceAll("That is one of the niggers", "Mrs G. That is one of the niggers").replaceAll("I have sent for you,", "Dr Gaines. I have sent for you,")
                                        .replaceAll("This will never do.", "Dr G. This will never do.").replaceAll("With the thoughts of", "Glen. With the thoughts of")
                                        .replaceAll("I think, Simeon", "Mrs Neal. I think, Simeon").replaceAll("I am glad those fellows", "Mr White. I am glad those fellows")
                                        .replaceAll("Dr G.", "Dr Gaines.").replaceAll("Mr G.", "Dr Gaines.").replaceAll("Mr Gaines.", "Dr Gaines.").replaceAll("Mr C.", "Mr Campbell.")
                                        .replaceAll("Mrs G.", "Mrs Gaines.").replaceAll("Mr P.", "Mr Pinchen.").replaceAll("Walk.", "Walker.").replaceAll("Wild.", "Wildmarsh.")
                                        .replaceAll("Mr N", "Mr Neal.").replaceAll("Samp.", "Sampey.").replaceAll("1st Loun.", "1st Lounger.").replaceAll("Tap.", "Tapioca.")
                                        .replaceAll("Hand me my fan", "Mrs Gaines. Hand me my fan").replaceAll("Mr White.", "White.").replaceAll("White.", "Mr White.")
                                        .replaceAll("And so thee wants", "Mr Neal. And so thee wants");
                                fix = fix.replaceAll("\\..", "\\.").replaceAll("’", "'");
                                String name = fix.substring(0, fix.indexOf(".") + 1).replaceAll("\\.", "");
                                System.out.println("Character: " + name + "\n");
                                if (charList.contains(name)) {
                                    id = charList.indexOf(name) + 1;
                                    Character.setAttribute("id", String.valueOf(id));
                                } else {
                                    charList.add(name);
                                    characterID++;
                                    Character.setAttribute("id", String.valueOf(characterID));
                                }
                                CharacterName.appendChild(document.createTextNode(name));
                                Character.appendChild(CharacterName);
                                //Act.appendChild(Character);
                                if (Scene != null) {
                                    Scene.appendChild(Character);
                                } else {
                                    Act.appendChild(Character);
                                }

                                String str = fix.substring(fix.indexOf(".") + 1, fix.length()).trim();
                                str = str.replaceAll("\\(", "\\[").replaceAll("\\)", "\\]");
                                if (str.contains("[")) {
                                    //Split the string into Stage directions and Speech
                                    String[] parts = str.split("(?<=])|(?=\\[)");

                                    for (String s : parts) {
                                        //CHARACTER STAGE DIRECTIONS
                                        if (s.contains("[")) {
                                            s = s.replaceAll("\\[", "").replaceAll("\\]", "").trim();
                                            System.out.println("Stage Directions: " + s + "\n");
                                            StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                                            StageDirections.appendChild(document.createTextNode(s));
                                            Character.appendChild(StageDirections);
                                        } else {
                                            //CAHARACTER SPEECH
                                            System.out.println("Speech: " + s.trim() + "\n");
                                            Speech = document.createElement("Λόγος");
                                            Speech.appendChild(document.createTextNode(s.trim()));
                                            Character.appendChild(Speech);
                                            //Act.appendChild(Character);
                                            if (Scene != null) {
                                                Scene.appendChild(Character);
                                            } else {
                                                Act.appendChild(Character);
                                            }
                                        }
                                    }
                                } else {
                                    //CHARACTER SPEECH ONLY
                                    System.out.println("Speech: " + str + "\n");
                                    Speech = document.createElement("Λόγος");
                                    Speech.appendChild(document.createTextNode(str));
                                    Character.appendChild(Speech);
                                    //Act.appendChild(Character);
                                    if (Scene != null) {
                                        Scene.appendChild(Character);
                                    } else {
                                        Act.appendChild(Character);
                                    }
                                }
                            }
                            if (Scene != null) {
                                Act.appendChild(Scene);
                            }
                        }
                        Play.appendChild(Act);
                        act = act.nextElementSibling();
                    }
                }
            } else if (chapterPerActOne != null) {
                System.out.println("ELEMENTS ARE NOT WITHIN THE <DIV CLASS=\"CHAPTER\">");
                org.jsoup.nodes.Element act = chapterPerActOne.parent();
                System.out.println(act);

                while (!act.text().contains("PROPERTY LIST") && !act.text().contains("THE END")) {
                    //ACT
                    if (act.hasClass("chapter")) {
                        Act = document.createElement("Πράξη");
                        actNumber++;
                        System.out.println("ACT " + actNumber + "\n");
                        Act.setAttribute("Νούμερο", String.valueOf(actNumber));
                        sceneNumber = 0;
                    }
                    //SCENE
                    if (act.text().contains("Scene")) {
                        Scene = document.createElement("Σκηνή");
                        sceneNumber++;
                        System.out.println("Scene " + sceneNumber + "\n");
                        Scene.setAttribute("Νούμερο", String.valueOf(sceneNumber));
                        scenes++;
                    }
                    //STAGE DIRECTIONS
                    if (act.tagName().equals("div") && act.hasClass("scene")) {
                        StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                        StageDirections.appendChild(document.createTextNode(act.text().replaceAll("\\[", "").replaceAll("\\]", "")));
                        System.out.println("Stage Directions: " + act.text() + "\n");
                        Scene.appendChild(StageDirections);
                    }
                    //STAGE DIRECTIONS
                    if (act.tagName().equals("blockquote")) {
                        StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                        StageDirections.appendChild(document.createTextNode(act.text().replaceAll("\\[", "").replaceAll("\\]", "")));
                        System.out.println("Stage Directions: " + act.text() + "\n");
                        Scene.appendChild(StageDirections);
                    }
                    if (act.tagName().equals("table")) {
                        org.jsoup.nodes.Element tr = act.select("tr").first();
                        System.out.println("First tr: " + tr);

                        while (tr != null) {
                            //CHARACTER
                            Character = document.createElement("Χαρακτήρας");
                            //CHARACTER NAME
                            CharacterName = document.createElement("Όνομα");
                            String fix = tr.text().replaceAll("Dr.", "Dr");
                            String name = fix.substring(0, fix.indexOf(".") + 1).replaceAll("\\.", "");
                            System.out.println("Character: " + name + "\n");
                            if (charList.contains(name)) {
                                id = charList.indexOf(name) + 1;
                                Character.setAttribute("id", String.valueOf(id));
                            } else {
                                charList.add(name);
                                characterID++;
                                Character.setAttribute("id", String.valueOf(characterID));
                            }
                            CharacterName.appendChild(document.createTextNode(name));
                            Character.appendChild(CharacterName);
                            Scene.appendChild(Character);

                            String str = fix.substring(fix.indexOf(".") + 1, fix.length()).trim();
                            str = str.replaceAll("\\(", "\\[").replaceAll("\\)", "\\]");
                            if (str.contains("[")) {
                                //Split the string into Stage directions and Speech
                                String[] parts = str.split("(?<=])|(?=\\[)");

                                for (String s : parts) {
                                    //CHARACTER STAGE DIRECTIONS
                                    if (s.contains("[")) {
                                        s = s.replaceAll("\\[", "").replaceAll("\\]", "").trim();
                                        System.out.println("Stage Directions: " + s + "\n");
                                        StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                                        StageDirections.appendChild(document.createTextNode(s));
                                        Character.appendChild(StageDirections);
                                    } else {
                                        //CAHARACTER SPEECH
                                        System.out.println("Speech: " + s + "\n");
                                        Speech = document.createElement("Λόγος");
                                        Speech.appendChild(document.createTextNode(s));
                                        Character.appendChild(Speech);
                                        Scene.appendChild(Character);

                                    }
                                }
                            } else {
                                //CHARACTER SPEECH ONLY
                                System.out.println("Speech: " + str + "\n");
                                Speech = document.createElement("Λόγος");
                                Speech.appendChild(document.createTextNode(str));
                                Character.appendChild(Speech);
                                Scene.appendChild(Character);
                            }
                            tr = tr.nextElementSibling();
                        }
                    }
                    if (act.tagName().equals("p")) {
                        //STAGE DIRECTIONS
                        if (act.hasClass("center") || act.hasClass("right") || act.hasClass("enter") || act.hasClass("exit") || act.hasClass("direction")) {
                            StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                            StageDirections.appendChild(document.createTextNode(act.text().replaceAll("\\[", "").replaceAll("\\]", "")));
                            System.out.println("Stage Directions: " + act.text() + "\n");
                            Scene.appendChild(StageDirections);
                        } else if (act.hasText() && !act.text().contains("[") && !act.hasClass("bottom-three")) {
                            //CHARACTER
                            Character = document.createElement("Χαρακτήρας");
                            //CHARACTER NAME
                            CharacterName = document.createElement("Όνομα");
                            String fix = act.text().replaceAll("Helena", "Helena.").replaceAll("Gall", "Gall.").replaceAll("Dr.", "Dr")
                                    .replaceAll("Mrs.", "Mrs").replaceAll("Mr.", "Mr").replaceAll("We mistresses", "Mrs G. We mistresses")
                                    .replaceAll("I am to have", "Mrs G. I am to have").replaceAll("I am glad to see you,", "Glen. I am glad to see you,")
                                    .replaceAll("Oh, how happy", "Melinda. Oh, how happy").replaceAll("But she must be sure", "Mr P. But she must be sure")
                                    .replaceAll("Why, how do you do, Squire", "Walk. Why, how do you do, Squire").replaceAll("Why, how do you do, Mr Pinchen", "Walk. Why, how do you do, Mr Pinchen")
                                    .replaceAll("Ah! my dear, I am glad you’ve come, I’ve been", "Dr G. Ah! my dear, I am glad you’ve come, I’ve been")
                                    .replaceAll("Ah! my dear, I am glad you’ve come.", "Dr Gaines. Ah! my dear, I am glad you’ve come.")
                                    .replaceAll("That man is enough", "Mrs Gaines. That man is enough").replaceAll("Good ebenin", "Cato. Good ebenin")
                                    .replaceAll("Dr Gaines, (in a low voice)", "Dr Gaines. (in a low voice)").replaceAll("I am glad that the Colonel", "Mrs G. I am glad that the Colonel")
                                    .replaceAll("Hannah needn’t", "Cato. Hannah needn’t").replaceAll("Walk in, sir", "Hannah. Walk in, sir")
                                    .replaceAll("That is one of the niggers", "Mrs G. That is one of the niggers").replaceAll("I have sent for you,", "Dr Gaines. I have sent for you,")
                                    .replaceAll("This will never do.", "Dr G. This will never do.").replaceAll("With the thoughts of", "Glen. With the thoughts of")
                                    .replaceAll("I think, Simeon", "Mrs Neal. I think, Simeon").replaceAll("I am glad those fellows", "Mr White. I am glad those fellows")
                                    .replaceAll("Dr G.", "Dr Gaines.").replaceAll("Mr G.", "Dr Gaines.").replaceAll("Mr Gaines.", "Dr Gaines.").replaceAll("Mr C.", "Mr Campbell.")
                                    .replaceAll("Mrs G.", "Mrs Gaines.").replaceAll("Mr P.", "Mr Pinchen.").replaceAll("Walk.", "Walker.").replaceAll("Wild.", "Wildmarsh.")
                                    .replaceAll("Mr N", "Mr Neal.").replaceAll("Samp.", "Sampey.").replaceAll("1st Loun.", "1st Lounger.").replaceAll("Tap.", "Tapioca.")
                                    .replaceAll("Hand me my fan", "Mrs Gaines. Hand me my fan").replaceAll("Mr White.", "White.").replaceAll("White.", "Mr White.")
                                    .replaceAll("And so thee wants", "Mr Neal. And so thee wants");
                            fix = fix.replaceAll("\\..", "\\.").replaceAll("’", "'");
                            String name = fix.substring(0, fix.indexOf(".") + 1).replaceAll("\\.", "");
                            System.out.println("Character: " + name + "\n");
                            if (charList.contains(name)) {
                                id = charList.indexOf(name) + 1;
                                Character.setAttribute("id", String.valueOf(id));
                            } else {
                                charList.add(name);
                                characterID++;
                                Character.setAttribute("id", String.valueOf(characterID));
                            }
                            CharacterName.appendChild(document.createTextNode(name));
                            Character.appendChild(CharacterName);
                            Scene.appendChild(Character);

                            String str = fix.substring(fix.indexOf(".") + 1, fix.length()).trim();
                            str = str.replaceAll("\\(", "\\[").replaceAll("\\)", "\\]");
                            if (str.contains("[")) {
                                //Split the string into Stage directions and Speech
                                String[] parts = str.split("(?<=])|(?=\\[)");

                                for (String s : parts) {
                                    //CHARACTER STAGE DIRECTIONS
                                    if (s.contains("[")) {
                                        s = s.replaceAll("\\[", "").replaceAll("\\]", "").trim();
                                        System.out.println("Stage Directions: " + s + "\n");
                                        StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                                        StageDirections.appendChild(document.createTextNode(s));
                                        Character.appendChild(StageDirections);
                                    } else {
                                        //CAHARACTER SPEECH
                                        System.out.println("Speech: " + s.trim() + "\n");
                                        Speech = document.createElement("Λόγος");
                                        Speech.appendChild(document.createTextNode(s.trim()));
                                        Character.appendChild(Speech);
                                        Scene.appendChild(Character);
                                    }
                                }
                            } else {
                                //CHARACTER SPEECH ONLY
                                System.out.println("Speech: " + str + "\n");
                                Speech = document.createElement("Λόγος");
                                Speech.appendChild(document.createTextNode(str));
                                Character.appendChild(Speech);
                                Scene.appendChild(Character);
                            }
                        }
                        Act.appendChild(Scene);
                    }
                    Play.appendChild(Act);
                    act = act.nextElementSibling();
                }
            } else if (firstAct != null) {
                System.out.println("\nFIRST ACT FORMAT \n");
                org.jsoup.nodes.Element act = firstAct;

                //<P> ELEMENTS ONE AFTER ANOTHER
                while (!act.tagName().equals("div")) {
                    //ACT
                    if (act.text().contains("ACT")) {
                        Act = document.createElement("Πράξη");
                        actNumber++;
                        System.out.println("Act " + actNumber + "\n");
                        Act.setAttribute("Νούμερο", String.valueOf(actNumber));
                        sceneNumber = 0;
                    }
                    //SCENE
                    if (act.text().contains("SCENE")) {
                        Scene = document.createElement("Σκηνή");
                        sceneNumber++;
                        System.out.println("Scene " + sceneNumber + "\n");
                        Scene.setAttribute("Νούμερο", String.valueOf(sceneNumber));
                        scenes++;
                    }
                    if (act.tagName().equals("p") && act.hasText()) {
                        //STAGE DIRECTIONS
                        if (act.text().startsWith("[")) {
                            System.out.println("Stage Directions: " + act.text() + "\n");
                            StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                            StageDirections.appendChild(document.createTextNode(act.text().replaceAll("\\[", "").replaceAll("\\]", "")));
                            Scene.appendChild(StageDirections);
                        } else if (act.child(0).tagName().equals("i")) {
                            System.out.println("Stage Directions: " + act.text() + "\n");
                            StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                            StageDirections.appendChild(document.createTextNode(act.text()));
                            Scene.appendChild(StageDirections);
                        } else if (act.hasAttr("style")) {
                            System.out.println("Stage Directions: " + act.text() + "\n");
                            StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                            StageDirections.appendChild(document.createTextNode(act.text()));
                            Scene.appendChild(StageDirections);
                        } else {
                            //CHARACTER
                            Character = document.createElement("Χαρακτήρας");
                            CharacterName = document.createElement("Όνομα");
                            //CHARACTER NAME
                            if (act.child(0).tagName().equals("span")) {
                                String name = act.child(0).text().trim();
                                System.out.println("Character: " + name + "\n");
                                if (charList.contains(name)) {
                                    id = charList.indexOf(name) + 1;
                                    Character.setAttribute("id", String.valueOf(id));
                                } else {
                                    charList.add(name);
                                    characterID++;
                                    Character.setAttribute("id", String.valueOf(characterID));
                                }
                                CharacterName.appendChild(document.createTextNode(name));
                                Character.appendChild(CharacterName);
                                Scene.appendChild(Character);

                                //Split Character String into speech
                                String str = act.text().substring(act.text().indexOf(".") + 1, act.text().length()).trim();

                                if (str.contains("[")) {
                                    //Split the string in Stage Directions and Speech
                                    String[] parts = str.split("(?<=])|(?=\\[)");

                                    for (String s : parts) {
                                        //STAGE DIRECTIONS
                                        if (s.contains("[")) {
                                            System.out.println("Stage Directions: " + s + "\n");
                                            StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                                            StageDirections.appendChild(document.createTextNode(s.replaceAll("\\[", "").replaceAll("\\]", "")));
                                            Character.appendChild(StageDirections);
                                            Scene.appendChild(Character);
                                        } else {
                                            //SPEECH
                                            s = s.trim();
                                            System.out.println("Speech: " + s + "\n");
                                            Speech = document.createElement("Λόγος");
                                            Speech.appendChild(document.createTextNode(s));
                                            Character.appendChild(Speech);
                                            Scene.appendChild(Character);
                                        }
                                    }
                                } else {
                                    //SPEECH ONLY
                                    System.out.println("Speech: " + str.trim() + "\n");
                                    Speech = document.createElement("Λόγος");
                                    Speech.appendChild(document.createTextNode(str.trim()));
                                    Character.appendChild(Speech);
                                    Scene.appendChild(Character);
                                }
                            }
                        }
                        Act.appendChild(Scene);
                    }
                    Play.appendChild(Act);
                    act = act.nextElementSibling();
                }
            } else if (actI != null) {
                System.out.println("\nACT I INSIDE <H2> FORMAT \n");
                //<H2> ELEMENT
                org.jsoup.nodes.Element act = actI.parent();

                //<P> ELEMENTS ONE AFTER ANOTHER
                while (!act.tagName().equals("pre")) {
                    //ACT
                    if (act.text().contains("ACT")) {
                        Act = document.createElement("Πράξη");
                        actNumber++;
                        System.out.println("Act " + actNumber + "\n");
                        Act.setAttribute("Νούμερο", String.valueOf(actNumber));
                        sceneNumber = 0;
                    }
                    //SCENE
                    if (act.text().contains("SCENE")) {
                        Scene = document.createElement("Σκηνή");
                        sceneNumber++;
                        System.out.println("Scene " + sceneNumber + "\n");
                        Scene.setAttribute("Νούμερο", String.valueOf(sceneNumber));
                        scenes++;
                    }
                    if (act.tagName().equals("blockquote")) {
                        //STAGE DIRECTIONS
                        org.jsoup.nodes.Element child = act.child(0);
                        while (child != null) {
                            System.out.println("Stage Directions: " + child.text() + "\n");
                            StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                            StageDirections.appendChild(document.createTextNode(child.text().replaceAll("\\[", "").replaceAll("\\]", "")));
                            if (Scene != null) {
                                Scene.appendChild(StageDirections);
                            } else {
                                Act.appendChild(StageDirections);
                            }
                            child = child.nextElementSibling();
                        }
                    }
                    if (act.tagName().equals("p") && act.hasText()) {
                        //STAGE DIRECTIONS
                        if (act.hasClass("scenedesc") || act.hasClass("right") || act.hasClass("nh")) {
                            System.out.println("Stage Directions: " + act.text() + "\n");
                            StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                            StageDirections.appendChild(document.createTextNode(act.text().replaceAll("\\[", "").replaceAll("\\]", "")));
                            if (Scene != null) {
                                Scene.appendChild(StageDirections);
                            } else {
                                Act.appendChild(StageDirections);
                            }
                        } else {
                            //CHARACTER
                            Character = document.createElement("Χαρακτήρας");
                            CharacterName = document.createElement("Όνομα");
                            //CHARACTER NAME
                            String fix = act.text().replaceAll("Hippolyta, I woo’d", "THESEUS. Hippolyta, I woo’d")
                                    .replaceAll("Helena, adieu", "LYSANDER. Helena, adieu").replaceAll("SNOUT", "SNOUT.")
                                    .replaceAll("SNUG", "SNUG.").replaceAll("ALL", "ALL.").replaceAll("FAIRY", "FAIRY.")
                                    .replaceAll("I’ll follow thee", "HELENA. I’ll follow thee").replaceAll("Hast thou the", "OBERON. Hast thou the")
                                    .replaceAll("Do it for thy", "OBERON. Do it for thy").replaceAll("Here comes my messenger", "OBERON. Here comes my messenger")
                                    .replaceAll("When thou wak’st, Thou", "PUCK. When thou wak’st, Thou").replaceAll("Be as thou wast", "OBERON. Be as thou wast")
                                    .replaceAll("Come, my queen", "OBERON. Come, my queen").replaceAll("We will, fair", "THESEUS. We will, fair")
                                    .replaceAll("Good morrow", "THESEUS. Good morrow").replaceAll("PROLOGUE", "PROLOGUE.")
                                    .replaceAll("Thanks, courteous", "PYRAMUS. Thanks, courteous").replaceAll("MOON", "MOON.")
                                    .replaceAll("Here she comes, and", "THESEUS. Here she comes, and").replaceAll("The iron tongue", "THESEUS. The iron tongue");
                            String name = fix.substring(0, fix.indexOf(".") + 1).replaceAll("\\.", "");
                            System.out.println("Character: " + name + "\n");
                            if (charList.contains(name)) {
                                id = charList.indexOf(name) + 1;
                                Character.setAttribute("id", String.valueOf(id));
                            } else {
                                charList.add(name);
                                characterID++;
                                Character.setAttribute("id", String.valueOf(characterID));
                            }
                            CharacterName.appendChild(document.createTextNode(name));
                            Character.appendChild(CharacterName);
                            if (Scene != null) {
                                Scene.appendChild(Character);
                            } else {
                                Act.appendChild(Character);
                            }

                            //Split Character String into speech
                            String str = act.text().substring(act.text().indexOf(".") + 1, act.text().length()).trim();

                            if (str.contains("[")) {
                                //Split the string in Stage Directions and Speech
                                String[] parts = str.split("(?<=])|(?=\\[)");

                                for (String s : parts) {
                                    //STAGE DIRECTIONS
                                    if (s.contains("[")) {
                                        System.out.println("Stage Directions: " + s + "\n");
                                        StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                                        StageDirections.appendChild(document.createTextNode(s.replaceAll("\\[", "").replaceAll("\\]", "")));
                                        Character.appendChild(StageDirections);
                                        if (Scene != null) {
                                            Scene.appendChild(StageDirections);
                                        } else {
                                            Act.appendChild(StageDirections);
                                        }
                                    } else {
                                        //SPEECH
                                        s = s.trim();
                                        System.out.println("Speech: " + s + "\n");
                                        Speech = document.createElement("Λόγος");
                                        Speech.appendChild(document.createTextNode(s));
                                        Character.appendChild(Speech);
                                        if (Scene != null) {
                                            Scene.appendChild(Character);
                                        } else {
                                            Act.appendChild(Character);
                                        }
                                    }
                                }
                            } else {
                                //SPEECH ONLY
                                System.out.println("Speech: " + str.trim() + "\n");
                                Speech = document.createElement("Λόγος");
                                Speech.appendChild(document.createTextNode(str.trim()));
                                Character.appendChild(Speech);
                                if (Scene != null) {
                                    Scene.appendChild(Character);
                                } else {
                                    Act.appendChild(Character);
                                }
                            }
                        }
                        if (Scene != null) {
                            Act.appendChild(Scene);
                        }
                    }
                    Play.appendChild(Act);
                    act = act.nextElementSibling();
                }
            } else if (actH2 != null && actH2.tagName().equals("h2")) {
                System.out.println("\nACT I THAT IS <H2> FORMAT \n");
                //<H2> ELEMENT
                org.jsoup.nodes.Element act = actH2;

                //<P> ELEMENTS ONE AFTER ANOTHER
                while (!act.tagName().equals("pre")) {
                    //ACT
                    if (act.text().contains("ACT ")) {
                        Act = document.createElement("Πράξη");
                        actNumber++;
                        System.out.println("Act " + actNumber + "\n");
                        Act.setAttribute("Νούμερο", String.valueOf(actNumber));
                        sceneNumber = 0;
                    }
                    if (act.tagName().equals("blockquote")) {
                        //STAGE DIRECTIONS
                        org.jsoup.nodes.Element child = act.child(0);
                        while (child != null) {
                            System.out.println("Stage Directions: " + child.text() + "\n");
                            StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                            StageDirections.appendChild(document.createTextNode(child.text().replaceAll("\\[", "").replaceAll("\\]", "")));
                            Act.appendChild(StageDirections);
                            child = child.nextElementSibling();
                        }
                    }
                    if (act.tagName().equals("p") && act.hasText()) {
                        //STAGE DIRECTIONS
                        if (act.hasClass("nh")) {
                            System.out.println("Stage Directions: " + act.text() + "\n");
                            StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                            StageDirections.appendChild(document.createTextNode(act.text().replaceAll("\\[", "").replaceAll("\\]", "")));
                            Act.appendChild(StageDirections);
                        } else if (act.tagName().equals("h3")) {
                            //STAGE DIRECTIONS
                            if (act.text().equals("CURTAIN")) {
                                System.out.println("Stage Directions: " + act.text() + "\n");
                                StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                                StageDirections.appendChild(document.createTextNode(act.text().replaceAll("\\[", "").replaceAll("\\]", "")));
                                Act.appendChild(StageDirections);
                            }
                        } else {
                            //CHARACTER
                            Character = document.createElement("Χαρακτήρας");
                            CharacterName = document.createElement("Όνομα");
                            //CHARACTER NAME
                            String fix = act.text().replaceAll("Physician", "Physician.").replaceAll("Madhav", "Madhav.")
                                    .replaceAll("Amal", "Amal.").replaceAll("First Boy", "First Boy.").replaceAll("Dairyman", "Dairyman.")
                                    .replaceAll("Boys", "Boys.").replaceAll("Gaffer", "Gaffer.").replaceAll("Fakir", "Fakir.")
                                    .replaceAll("Doctor", "Doctor.").replaceAll("Voice", "Voice.").replaceAll("Headman", "Headman.");
                            fix = fix.replaceAll("\\..", "\\.");
                            String name = fix.substring(0, fix.indexOf(".") + 1).replaceAll("\\.", "");
                            System.out.println("Character: " + name + "\n");
                            if (charList.contains(name)) {
                                id = charList.indexOf(name) + 1;
                                Character.setAttribute("id", String.valueOf(id));
                            } else {
                                charList.add(name);
                                characterID++;
                                Character.setAttribute("id", String.valueOf(characterID));
                            }
                            CharacterName.appendChild(document.createTextNode(name));
                            Character.appendChild(CharacterName);
                            Act.appendChild(Character);

                            //Split Character String into speech
                            String str = act.text().substring(act.text().indexOf(".") + 1, act.text().length()).trim();

                            if (str.contains("[")) {
                                //Split the string in Stage Directions and Speech
                                String[] parts = str.split("(?<=])|(?=\\[)");

                                for (String s : parts) {
                                    //STAGE DIRECTIONS
                                    if (s.contains("[")) {
                                        System.out.println("Stage Directions: " + s + "\n");
                                        StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                                        StageDirections.appendChild(document.createTextNode(s.replaceAll("\\[", "").replaceAll("\\]", "")));
                                        Character.appendChild(StageDirections);
                                        Act.appendChild(StageDirections);
                                    } else {
                                        //SPEECH
                                        s = s.trim();
                                        System.out.println("Speech: " + s + "\n");
                                        Speech = document.createElement("Λόγος");
                                        Speech.appendChild(document.createTextNode(s));
                                        Character.appendChild(Speech);
                                        Act.appendChild(Character);
                                    }
                                }
                            } else {
                                //SPEECH ONLY
                                System.out.println("Speech: " + str.trim() + "\n");
                                Speech = document.createElement("Λόγος");
                                Speech.appendChild(document.createTextNode(str.trim()));
                                Character.appendChild(Speech);
                                Act.appendChild(Character);
                            }
                        }
                    }
                    Play.appendChild(Act);
                    act = act.nextElementSibling();
                }
            }

            /*
            
            //MASTER BUILDER & HAMLET
            org.jsoup.nodes.Element cont = scrape.select("body :contains(CONTENTS  )").first();
            if (cont != null) {
                cont = cont.nextElementSibling();
                //MASTER BUILDER
                if (cont.tagName().equals("table")) {
                    for (org.jsoup.nodes.Element e : cont.select("p")) {
                        Elements contents = e.select("a");
                        System.out.println(contents.text());
                        Contents.appendChild(document.createTextNode(contents.text()));
                    }
                    //HAMLET
                } else if (cont.tagName().equals("p")) {
                    org.jsoup.nodes.Element contents = cont;
                    System.out.println(contents.text());
                    Contents.appendChild(document.createTextNode(contents.text()));
                }
            }
            

            //INTRODUCTION           
            org.jsoup.nodes.Element intro = scrape.select("body :contains(INTRODUCTION)").last();

            //MASTER BUILDER
            if (intro != null) {
                System.out.println("INTRODUCTION: ");
                System.out.println("\n");
                //Everything between 2nd <hr> and 3rd <hr>
                //Elements intro = scrape.select("hr:nth-of-type(2) ~ *:not(hr:nth-of-type(3) ~ *)");
                Introduction = document.createElement("Εισαγωγή");

                while (!intro.tagName().equals("h1")) {
                    //Check if element type is <p>
                    if (intro.tagName().equals("p")) {
                        if (!intro.hasText()) {
                            break;
                        } else {
                            System.out.println("Notes: " + intro.text() + "\n");
                            //Notes insert to XML
                            Element Notes = document.createElement("Σχόλιο");
                            Notes.appendChild(document.createTextNode(intro.text()));
                            Introduction.appendChild(Notes);
                        }
                    }
                    //Check if element type is <pre>
                    if (intro.tagName().equals("pre")) {
                        if (!intro.hasText()) {
                            break;
                        } else {
                            System.out.println("Excerpts: " + intro.text() + "\n");
                            Element Excerpts = document.createElement("Απόσπασμα");
                            Excerpts.appendChild(document.createTextNode(intro.text()));
                            Introduction.appendChild(Excerpts);
                        }
                    }
                    intro = intro.nextElementSibling();
                }
                Play.appendChild(Introduction);
                System.out.println("\n" + "------------------------------------------" + "\n");
            } else {
                System.out.println("NO INTRODUCTION " + "\n");
                System.out.println("\n" + "------------------------------------------" + "\n");
            }

            
            //MASTER BUILDER
            org.jsoup.nodes.Element c = scrape.select("body :contains(CHARACTERS.  )").first();
            //MASTER BUILDER
            if (c != null) {
                c = c.child(0);
                Elements chars = new Elements();

                while (!c.text().contains("ACT FIRST") && c.hasText()) {
                    chars.add(c);
                    c = c.nextElementSibling();
                }
                for (org.jsoup.nodes.Element e : chars) {
                    System.out.println(e.text().trim());
                    Characters = document.createElement("Χαρακτήρες");
                    //Characters insert to XML
                    Characters.appendChild(document.createTextNode(e.text()));
                }
                Play.appendChild(Characters);
                System.out.println("\n" + "------------------------------------------" + "\n");
            }


            //MASTER BUILDER
            org.jsoup.nodes.Element act1 = scrape.select("div.play").first();
            
            //MASTER BUILDER
            if (act1 != null) {
                org.jsoup.nodes.Element act = act1.child(0);
                while (!act.tagName().equals("h2")) {
                    act = act.nextElementSibling();
                }
                //Until last element
                while (act != null) {
                    //ACT
                    if (act.tagName().equals("h2")) {
                        Act = document.createElement("Πράξη");
                        System.out.println("ACT " + actNumber);
                        System.out.println("\n");
                        actNumber++;
                        Act.setAttribute("Νούμερο", String.valueOf(actNumber));
                    }
                    //Create Text Node
                    org.jsoup.nodes.TextNode actNode = (org.jsoup.nodes.TextNode) act.nextSibling();

                    //EXCERPT
                    if (act.tagName().equals("pre")) {
                        System.out.println("Excerpt: " + act.text() + "\n");
                        String ex = act.text().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\r*\n*", "").replaceAll("       ", "");
                        Excerpt = document.createElement("Απόσπασμα");
                        Excerpt.appendChild(document.createTextNode(ex));
                        Act.appendChild(Excerpt);
                    }
                    //CHARACTER
                    if (act.tagName().equals("p")) {
                        if (act.text().contains("[")) {
                            //Split the string into Stage Directions and Speech 
                            String[] parts = act.text().split("(?<=])|(?=\\[)");
                            for (String s : parts) {
                                //STAGE DIRECTIONS
                                if (s.contains("[")) {
                                    s = s.trim();
                                    System.out.println("Stage Directions: " + s + "\n");
                                    StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                                    StageDirections.appendChild(document.createTextNode(s.replaceAll("\\[", "").replaceAll("\\]", "")));
                                    Character.appendChild(StageDirections);
                                    Act.appendChild(Character);
                                } else {
                                    //SPEECH
                                    s = s.replaceAll("—", "").trim();
                                    System.out.println("Speech: " + s + "\n");
                                    Speech = document.createElement("Λόγος");
                                    Speech.appendChild(document.createTextNode(s));
                                    Character.appendChild(Speech);
                                    Act.appendChild(Character);
                                }
                            }
                        } else {
                            //SPEECH ONLY
                            String speech = act.text().replaceAll("—", "").trim();
                            System.out.println("Speech: " + speech + "\n");
                            Speech = document.createElement("Λόγος");
                            Speech.appendChild(document.createTextNode(speech));
                            Character.appendChild(Speech);
                            Act.appendChild(Character);
                        }
                    }
                    //CHARACTER NAME
                    if (!actNode.isBlank()) {
                        String name = actNode.text().replaceAll("\\.", "").trim();
                        System.out.println("Character: " + name + "\n");
                        Character = document.createElement("Χαρακτήρας");
                        CharacterName = document.createElement("Όνομα");
                        if (charList.contains(name)) {
                            id = charList.indexOf(name) + 1;
                            Character.setAttribute("id", String.valueOf(id));
                        } else {
                            charList.add(name);
                            characterID++;
                            Character.setAttribute("id", String.valueOf(characterID));
                        }
                        CharacterName.appendChild(document.createTextNode(name));
                        Character.appendChild(CharacterName);
                        Act.appendChild(Character);
                    }
                    Play.appendChild(Act);
                    System.out.println("\n" + "------------------------------------------" + "\n");
                    act = act.nextElementSibling();
                }
                rootElement.appendChild(Play);
            } else {
                System.out.println("NO MASTER BUILDER " + "\n");
                System.out.println("\n" + "------------------------------------------" + "\n");
            }
             */
            rootElement.appendChild(Play);
            System.out.println(charList);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            //Xml encoding property
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            //Xml indentation property
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            DOMSource source = new DOMSource(document);

            //Convert to String
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            transformer.transform(source, result);
            //Print output to string
            String output = writer.toString().replaceAll("�", "-").replaceAll("&amp;", "");

            //Create file name
            myXMLFile = new File("file.xml");
            //Write XML to file
            PrintWriter pw = null;
            try {
                //Clear file contents
                pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(myXMLFile, false), StandardCharsets.UTF_8));
                //Write to file
                pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(myXMLFile, true), StandardCharsets.UTF_8));
                pw.println(output);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            pw.flush();
            pw.close();

            //Read myXMLFile to determine the line number
            NumberedFile = new File("NumberedFile.txt");
            int lineNumber = 1;
            BufferedReader br = null;
            try {
                //Read file
                br = new BufferedReader(new InputStreamReader(new FileInputStream(myXMLFile), StandardCharsets.UTF_8));
                String line = br.readLine();
                while (line != null) {
                    //Read next line
                    line = br.readLine();
                    lineNumber++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            br.close();

            //Write line numbers to NumberedFile
            int line = 1;
            BufferedWriter bw = null;
            try {
                //Clear file contents
                bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(NumberedFile, false), StandardCharsets.UTF_8));
                //Write to file
                bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(NumberedFile, true), StandardCharsets.UTF_8));
                for (int i = 1; i <= lineNumber; i++) {
                    //4 digit numbers
                    bw.write(String.format("%4d", line));
                    bw.newLine();
                    line++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            bw.close();

            //Create Line numbers TextPane
            lineNumbers = new JTextPane();
            lineNumbers.setEditable(false);

            //Set Background Color
            Color bgColor = Color.lightGray;
            UIDefaults defaults = new UIDefaults();
            defaults.put("TextPane.background", new ColorUIResource(bgColor));
            defaults.put("TextPane[Enabled].backgroundPainter", bgColor);
            lineNumbers.putClientProperty("Nimbus.Overrides", defaults);
            lineNumbers.putClientProperty("Nimbus.Overrides.InheritDefaults", true);
            lineNumbers.setBackground(bgColor);

            //Line numbers right-aligned
            SimpleAttributeSet rightAlign = new SimpleAttributeSet();
            StyleConstants.setAlignment(rightAlign, StyleConstants.ALIGN_RIGHT);
            lineNumbers.setParagraphAttributes(rightAlign, true);

            //Load line numbers on TextPane
            FileReader reader = new FileReader(NumberedFile);
            lineNumbers.read(reader, NumberedFile);

            Document d = XMLEditorPane.getDocument();
            //Add Document Listener
            d.addDocumentListener(new DocumentListener() {
                @Override
                public void changedUpdate(DocumentEvent e) {
                    //lineNumbers();
                }

                @Override
                public void insertUpdate(DocumentEvent e) {
                    //lineNumbers();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    //lineNumbers();
                }
            });
            //Set main component in XMLScrollPane
            XMLScrollPane.getViewport().add(XMLEditorPane);
            //Add lineNumbers as RowHeader on the left side of XMLEditorPane
            XMLScrollPane.setRowHeaderView(lineNumbers);
            XMLScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            //Create XMLEditorKit
            XMLEditorKit xmlkit = new XMLEditorKit();
            XMLEditorPane.setEditorKit(xmlkit);
            //Load file on XMLEditorPane
            XMLEditorPane.setText(output);
            //Set the font style
            XMLEditorPane.setFont(new Font("Courier", Font.PLAIN, 12));
            //Set the tab size
            XMLEditorPane.getDocument().putProperty(PlainDocument.tabSizeAttribute, new Integer(4));
            //Enable auto indentation.
            xmlkit.setAutoIndentation(true);
            //Enable tag completion.
            xmlkit.setTagCompletion(true);
            //Enable error highlighting.
            XMLEditorPane.getDocument().putProperty(XMLEditorKit.ERROR_HIGHLIGHTING_ATTRIBUTE, new Boolean(true));
            //Set a style
            xmlkit.setStyle(XMLStyleConstants.ATTRIBUTE_NAME, new Color(255, 0, 0), Font.BOLD);
            XMLPanel.add(new XMLFoldingMargin(XMLEditorPane), BorderLayout.EAST);
            XMLPanel.add(new LineNumberMargin(XMLEditorPane), BorderLayout.WEST);

        } catch (ParserConfigurationException | TransformerException | IOException e) {
            e.printStackTrace();
        }
    }

    public void ScrapeandLoadXMLfromFile(File f) {
        //Enable Validation button
        XMLValidationButton.setEnabled(true);

        String dbUrl = "jdbc:mysql://localhost/theatrical_plays?useUnicode=true&character_set_server=utf8mb4&characterEncoding=UTF-8";
        String username = "root";
        String password = "root123456";

        try {
            scrape = Jsoup.parse(f, "UTF-8");

            DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
            document = documentBuilder.newDocument();

            //ROOT ELEMENT
            rootElement = document.createElement("Έργα");
            document.appendChild(rootElement);
            characterID = 0;

            //PLAY
            Play = document.createElement("Έργο");
            Title = document.createElement("Τίτλος");
            AuthorID = document.createElement("Συγγραφέας_ID");
            ReleaseDate = document.createElement("Ημερομηνία_Κυκλοφορίας");
            Genre = document.createElement("Είδος");
            PlayURL = document.createElement("URL");

            //PLAY TITLE
            Title.appendChild(document.createTextNode(playTitle));
            System.out.println("\n" + "Play Title: " + playTitle);
            rootElement.appendChild(Title);

            //PLAY ID
            org.jsoup.nodes.Element pid = scrape.select("body :contains(Release Date)").first();
            org.jsoup.nodes.Element prePid = null;
            //<PRE> FORMAT
            if (pid.tagName().equals("pre")) {
                prePid = pid;
            }
            String ID = pid.text().substring(pid.text().indexOf('[') + 1, pid.text().indexOf(']'));
            ID = ID.replaceAll("[a-zA-Z# ]", "");
            playID = Integer.parseInt(ID);
            Play.setAttribute("id", String.valueOf(playID));
            System.out.println("Play ID: " + ID);

            //AUTHOR ID
            org.jsoup.nodes.Element a = scrape.select("title").first();
            String author = null;

            if (a != null) {
                if (a.text().contains("by") || a.text().contains("By")) {
                    author = a.text().substring(a.text().indexOf(",") + 1, a.text().length()).trim();
                    if (author.contains(",")) {
                        author = author.substring(author.indexOf(",") + 1, author.length()).trim();
                    }
                    author = author.replace("By", "").replaceAll("by", "").replaceAll("\\.", "").trim();
                } else if (a.text().contains(",")) {
                    author = a.text().substring(a.text().indexOf(",") + 1, a.text().length()).trim();
                    author = author.substring(0, author.indexOf(",")).trim();
                }
            }
            try {
                //Create connection
                java.sql.Connection con = DriverManager.getConnection(dbUrl, username, password);

                PreparedStatement st = con.prepareStatement("SELECT Όνομα FROM συγγραφέας WHERE Όνομα = ?");
                st.setString(1, author);
                ResultSet rs = st.executeQuery();

                //Check if author Name already exists in the Database
                if (rs.next()) {
                    //System.out.println("Author: " + author + " already exists");
                    PreparedStatement authorExists = con.prepareStatement("SELECT Συγγραφέας FROM συγγραφέας WHERE Όνομα = ?");
                    authorExists.setString(1, author);
                    ResultSet authorRS = authorExists.executeQuery();

                    if (authorRS.next()) {
                        authorID = authorRS.getInt(1);
                        AuthorID.appendChild(document.createTextNode(String.valueOf(authorID)));;
                    }
                    //If author Name doesn't exist in the Database
                } else {
                    //System.out.println("Author " + author + " doesn't exist");
                    PreparedStatement authorNotExists = con.prepareStatement("SELECT COUNT(*) FROM συγγραφέας");
                    ResultSet authorRS = authorNotExists.executeQuery();

                    if (authorRS.next()) {
                        authorID = authorRS.getInt(1) + 1;
                        AuthorID.appendChild(document.createTextNode(String.valueOf(authorID)));
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }

            //RELEASE DATE
            if (prePid != null) {
                String s = "";
                for (int i = 0; i < prePid.text().length(); i++) {
                    char c = prePid.text().charAt(i);
                    s += c;
                    if (c == ']') {
                        String date = s.substring(s.lastIndexOf(':') + 1, s.indexOf('['));
                        date = date.replaceAll("^([^\\s]*)(\\s)", "").trim();
                        ReleaseDate.appendChild(document.createTextNode(date));
                        System.out.println("Release Date: " + date);
                        break;
                    }
                }
            } else {
                String date = pid.text().substring(pid.text().indexOf(':') + 1, pid.text().indexOf('['));
                date = date.replaceAll("^([^\\s]*)(\\s)", "").trim();
                ReleaseDate.appendChild(document.createTextNode(date));
                System.out.println("Release Date: " + date);
            }

            //GENRE
            if (Title.getTextContent().contains("Doll's House") || Title.getTextContent().contains("Hamlet")) {
                String genre = "Tragedy";
                Genre.appendChild(document.createTextNode(genre));
                System.out.println("Play Genre: " + genre);
            } else if (Title.getTextContent().contains("Being Earnest") || Title.getTextContent().contains("Midsummer Night's Dream")
                    || Title.getTextContent().contains("The Playboy")) {
                String genre = "Comedy";
                Genre.appendChild(document.createTextNode(genre));
                System.out.println("Play Genre: " + genre);
            } else if (Title.getTextContent().contains("Pygmalion") || Title.getTextContent().contains("Ideal Husband")) {
                String genre = "Romantic Comedy";
                Genre.appendChild(document.createTextNode(genre));
                System.out.println("Play Genre: " + genre);
            } else if (Title.getTextContent().contains("Rossum's Universal Robots")) {
                String genre = "Science Fiction";
                Genre.appendChild(document.createTextNode(genre));
                System.out.println("Play Genre: " + genre);
            } else if (Title.getTextContent().contains("Post Office") || Title.getTextContent().contains("A Leap For Freedom")) {
                String genre = "Drama";
                Genre.appendChild(document.createTextNode(genre));
                System.out.println("Play Genre: " + genre);
            }

            //URL
            PlayURL.appendChild(document.createTextNode(playURL));
            System.out.println("Play URL: " + playURL);

            //Append Child Elements
            Play.appendChild(Title);
            Play.appendChild(AuthorID);
            Play.appendChild(ReleaseDate);
            Play.appendChild(Genre);
            Play.appendChild(PlayURL);
            System.out.println("\n" + "------------------------------------------" + "\n");

            //AUTHOR
            Author = document.createElement("Συγγραφέας");
            AuthorName = document.createElement("Όνομα");
            AuthorBirthDate = document.createElement("Ημερομηνία_Γέννησης");
            AuthorBio = document.createElement("Βιογραφία");

            //AUTHOR ID
            Author.setAttribute("id", String.valueOf(authorID));
            System.out.println("Author ID: " + authorID);

            //AUTHOR NAME
            AuthorName.appendChild(document.createTextNode(author));
            System.out.println("Author Name: " + author);

            //AUTHOR BIRTH DATE & BIO
            if (author.contains("Shakespeare")) {
                AuthorBirthDate.appendChild(document.createTextNode("1564-04-26"));
                AuthorBio.appendChild(document.createTextNode("Ο Ουίλλιαμ Σαίξπηρ ήταν Άγγλος ποιητής και θεατρικός συγγραφέας. "
                        + "Θεωρείται ευρέως ως ο σημαντικότερος συγγραφέας που έγραψε "
                        + "στην αγγλική γλώσσα και ένας από τους σημαντικότερους "
                        + "δραματουργούς παγκοσμίως. Συχνά αποκαλείται "
                        + "εθνικός ποιητής της Αγγλίας και «Βάρδος του Έιβον»."));
            } else if (author.contains("Ibsen")) {
                AuthorBirthDate.appendChild(document.createTextNode("1828-03-20"));
                AuthorBio.appendChild(document.createTextNode("Ο Χένρικ Ίψεν ήταν Νορβηγός θεατρικός συγγραφέας και σκηνοθέτης. "
                        + "Ως ένας από τους ιδρυτές του μοντερνισμού στο θέατρο, "
                        + "ο Ιψεν αναφέρεται συχνά ως ο πατέρας του ρεαλισμού και "
                        + "ένας από τους πιο επιδραστικούς θεατρικούς συγγραφείς της εποχής του."));
            } else if (author.contains("Wilde")) {
                AuthorBirthDate.appendChild(document.createTextNode("1854-10-16"));
                AuthorBio.appendChild(document.createTextNode("Ο Όσκαρ Γουάιλντ ήταν Ιρλανδός μυθιστοριογράφος, ποιητής, "
                        + "δραματουργός και κριτικός. Έχοντας περάσει από διάφορα είδη "
                        + "γραπτού λόγου καθ' όλη τη δεκαετία του 1880, "
                        + "γεύτηκε τη δόξα ως θεατρικός συγγραφέας στο Λονδίνο "
                        + "στις αρχές της επόμενης δεκαετίας."));
            } else if (author.contains("Bernard Shaw")) {
                AuthorBirthDate.appendChild(document.createTextNode("1856-07-26"));
                AuthorBio.appendChild(document.createTextNode("Ο Tζορτζ Μπέρναρντ Σω ήταν Ιρλανδός στην καταγωγή και υπήρξε κριτικός, "
                        + "δραματουργός και θεατρικός συγγραφέας, "
                        + "που τιμήθηκε με το Νόμπελ Λογοτεχνίας το 1925."));
            } else if (author.contains("Capek")) {
                AuthorBirthDate.appendChild(document.createTextNode("1890-01-09"));
                AuthorBio.appendChild(document.createTextNode("Ο Κάρελ Τσάπεκ ήταν Τσέχος μυθιστοριογράφος, διηγηματογράφος, "
                        + "και θεατρικός συγγραφέας, γεννημένος στο "
                        + "Μάλε Σβατονόβιτσε της ανατολικής Βοημίας το 1890."));
            } else if (author.contains("Tagore")) {
                AuthorBirthDate.appendChild(document.createTextNode("1861-05-07"));
                AuthorBio.appendChild(document.createTextNode("Ο Ραμπιντρανάθ Ταγκόρ, ήταν Ινδός συνθέτης, ζωγράφος, "
                        + "συγγραφέας και φιλόσοφος, του οποίου το έργο είχε σημαντική επίδραση "
                        + "στη λογοτεχνία και τη μουσική της Βεγγάλης στα τέλη του 19ου και τις αρχές "
                        + "του 20ού αιώνα και στον οποίο απονεμήθηκε το Βραβείο Νόμπελ Λογοτεχνίας το 1913."));
            } else if (author.contains("Wells Brown")) {
                AuthorBirthDate.appendChild(document.createTextNode("1815-03-15"));
                AuthorBio.appendChild(document.createTextNode("Ο Γουίλιαμ Γουέλς Μπράουν ήταν εξέχων αφρικανικός-αμερικανικός "
                        + "καθηγητής καταργητών, μυθιστοριογράφος, θεατρικός συγγραφέας και ιστορικός στις Ηνωμένες Πολιτείες. "
                        + "Γεννημένος σε δουλεία στο Montgomery County, Κεντάκι, "
                        + "κοντά στην πόλη του Mount Sterling, ο Μπράουν δραπέτευσε στο Οχάιο το 1834 σε ηλικία 19 ετών."));
            } else if (author.contains("Synge")) {
                AuthorBirthDate.appendChild(document.createTextNode("1871-04-16"));
                AuthorBio.appendChild(document.createTextNode("Ο Edmund John Millington Synge ήταν ιρλανδός θεατρικός συγγραφέας, ποιητής, "
                        + "συγγραφέας, συλλέκτης λαογραφίας και βασική προσωπικότητα  "
                        + "στην ιρλανδική λογοτεχνική αναβίωση."));
            } else {
                AuthorBirthDate.appendChild(document.createTextNode("????-??-??"));
                AuthorBio.appendChild(document.createTextNode("????"));
            }
            //Append Child Elements
            Author.appendChild(AuthorName);
            Author.appendChild(AuthorBirthDate);
            Author.appendChild(AuthorBio);
            Play.appendChild(Author);
            System.out.println("\n" + "------------------------------------------" + "\n");

            //CONTENTS
            Contents = document.createElement("Περιεχόμενα");

            //<A HREF> IN <TABLE> ELEMENT
            org.jsoup.nodes.Element contentsTable = scrape.select("table").first();
            if (contentsTable != null) {
                for (org.jsoup.nodes.Element contents : contentsTable.select("a")) {
                    Contents.appendChild(document.createTextNode(contents.text() + " "));
                    System.out.println("Play Contents: " + contents.text());
                    Play.appendChild(Contents);
                }
            }
            //<A HREF> INSIDE <P> FORMAT
            for (org.jsoup.nodes.Element p : scrape.select("p")) {
                for (org.jsoup.nodes.Element contents : p.select("a")) {
                    if (contents != null && contents.text().contains("[a-zA-Z]")) {
                        Contents.appendChild(document.createTextNode(contents.text().trim() + " "));
                        System.out.println("Play Contents: " + contents.text().trim());
                        Play.appendChild(Contents);
                    }
                }
            }
            //<A HREF> INSIDE <DIV CLASS="PH4"> FORMAT
            for (org.jsoup.nodes.Element p : scrape.select("div.ph4")) {
                for (org.jsoup.nodes.Element contents : p.select("a")) {
                    Contents.appendChild(document.createTextNode(contents.text() + " "));
                    System.out.println("Play Contents: " + contents.text());
                    Play.appendChild(Contents);
                }
            }
            //THE SCENES OF THE PLAY FORMAT
            org.jsoup.nodes.Element scenesofPlay = scrape.select("body :contains(THE SCENES OF THE PLAY)").first();
            if (scenesofPlay != null) {
                scenesofPlay = scenesofPlay.nextElementSibling();
                //<P> ELEMENTS ONE AFTER ANOTHER FORMAT
                while (scenesofPlay.tagName().equals("p")) {
                    org.jsoup.nodes.Element contents = scenesofPlay;
                    Contents.appendChild(document.createTextNode(contents.text() + "\n"));
                    System.out.println("Play Contents: " + contents.text());
                    scenesofPlay = scenesofPlay.nextElementSibling();
                }
                Play.appendChild(Contents);
            }
            //CONTENTS IN <H2> FORMAT
            org.jsoup.nodes.Element contents = scrape.select("body :contains(Contents)").first();
            if (contents != null && contents.tagName().equals("h2")) {
                contents = contents.nextElementSibling();
                //ALL CONTENTS IN ONE <P> ELEMENT FORMAT
                if (contents.tagName().equals("p")) {
                    String content = contents.text().trim();
                    Contents.appendChild(document.createTextNode(content + "\n"));
                    System.out.println("Play Contents: " + content);
                }
                Play.appendChild(Contents);
            }
            //THE SCENES FORMAT
            org.jsoup.nodes.Element theScenes = scrape.select("body :contains(THE SCENES)").first();
            if (theScenes != null) {
                //<TABLE> FORMAT
                if (theScenes.tagName().equals("table")) {
                    for (org.jsoup.nodes.Element c : theScenes.select("tr")) {
                        Contents.appendChild(document.createTextNode(c.text().trim() + " "));
                        System.out.println("Play Contents: " + c.text().trim());
                    }
                }
            }
            Play.appendChild(Contents);
            System.out.println("\n" + "------------------------------------------" + "\n");

            //INTRODUCTION
            Introduction = document.createElement("Εισαγωγή");

            //STORY OF THE PLAY FORMAT
            org.jsoup.nodes.Element storyofPlay = scrape.select("body :contains(STORY OF THE PLAY)").first();
            if (storyofPlay != null) {
                storyofPlay = storyofPlay.nextElementSibling();
                //<P> ELEMENTS FORMAT
                while (storyofPlay.tagName().equals("p")) {
                    String introduction = storyofPlay.text().replaceAll("\\[", "").replaceAll("\\]", "");
                    Introduction.appendChild(document.createTextNode(introduction));
                    System.out.println("Introduction of Play: " + "\n" + introduction);
                    storyofPlay = storyofPlay.nextElementSibling();
                }
                Play.appendChild(Introduction);
            }
            //AUTHOR’S PREFACE FORMAT
            org.jsoup.nodes.Element authorPreface = scrape.select("body :contains(AUTHOR’S PREFACE)").first();
            if (authorPreface != null) {
                authorPreface = authorPreface.nextElementSibling();
                //<P> ELEMENTS FORMAT
                while (!authorPreface.text().contains("[")) {
                    if (authorPreface.tagName().equals("p")) {
                        String introduction = authorPreface.text();
                        Introduction.appendChild(document.createTextNode(introduction));
                        System.out.println("Introduction of Play: " + "\n" + introduction);
                    }
                    authorPreface = authorPreface.nextElementSibling();
                }
                Play.appendChild(Introduction);
            } else {
                //PREFACE FORMAT
                org.jsoup.nodes.Element preface = scrape.select("body :contains(PREFACE)").last();
                if (preface != null && preface.tagName().equals("h2")) {
                    preface = preface.nextElementSibling();
                    //<P> ELEMENTS FORMAT
                    if (preface.tagName().equals("p")) {
                        String introduction = preface.text();
                        Introduction.appendChild(document.createTextNode(introduction));
                        System.out.println("Introduction of Play: " + "\n" + introduction);
                        Play.appendChild(Introduction);
                    }
                }
            }
            System.out.println("\n" + "------------------------------------------" + "\n");

            //CHARACTERS
            Characters = document.createElement("Χαρακτήρες");

            //CHARACTERS (IN ORDER OF APPEARENCE) FORMAT
            org.jsoup.nodes.Element chars = scrape.select("body :contains(CHARACTERS (in order of appearance))").first();
            if (chars != null) {
                chars = chars.nextElementSibling();
                //<TABLE> FORMAT
                for (org.jsoup.nodes.Element c : chars.select("span")) {
                    String characters = c.text().replaceAll("\\[", "").replaceAll("\\]", "");
                    Characters.appendChild(document.createTextNode(characters));
                    System.out.println("Characters of Play: " + characters);
                    Play.appendChild(Characters);
                }
            }
            //DRAMATIS PERSONAE FORMAT
            org.jsoup.nodes.Element dramatisPersonae = scrape.select("body :contains(Dramatis Person)").first();
            if (dramatisPersonae != null) {
                dramatisPersonae = dramatisPersonae.nextElementSibling();
                //<P> ELEMENTS FORMAT
                if (dramatisPersonae.tagName().equals("p")) {
                    String characters = dramatisPersonae.text().replaceAll("\\[", "").replaceAll("\\]", "");
                    Characters.appendChild(document.createTextNode(characters));
                    System.out.println("Characters of Play: " + "\n" + characters);
                    Play.appendChild(Characters);
                }
                if (dramatisPersonae.tagName().equals("ul")) {
                    String characters = dramatisPersonae.text().replaceAll("\\[", "").replaceAll("\\]", "");
                    Characters.appendChild(document.createTextNode(characters));
                    System.out.println("Characters of Play: " + "\n" + characters);
                    Play.appendChild(Characters);
                }
            }
            //THE PERSONS OF THE PLAY FORMAT
            org.jsoup.nodes.Element personsofPlay = scrape.select("body :contains(THE PERSONS OF THE PLAY)").first();
            if (personsofPlay != null) {
                personsofPlay = personsofPlay.nextElementSibling();
                //<P> ELEMENTS ONE AFTER ANOTHER FORMAT
                while (personsofPlay.tagName().equals("p")) {
                    org.jsoup.nodes.Element characters = personsofPlay;
                    Characters.appendChild(document.createTextNode(characters.text() + "\n"));
                    System.out.println("Characters of Play: " + "\n" + characters);
                    personsofPlay = personsofPlay.nextElementSibling();
                }
                Play.appendChild(Characters);
            }
            //THE PERSONS IN THE PLAY FORMAT
            org.jsoup.nodes.Element personsinPlay = scrape.select("body :contains(THE PERSONS IN THE PLAY)").first();
            if (personsinPlay != null) {
                personsinPlay = personsinPlay.nextElementSibling();
                //ALL CHARACTERS IN ONE <P> FORMAT
                if (personsinPlay.tagName().equals("p")) {
                    String characters = personsinPlay.text();
                    Characters.appendChild(document.createTextNode(characters));
                    System.out.println("Characters of Play: " + "\n" + characters);
                    Play.appendChild(Characters);
                }
            }
            //PERSONS FORMAT
            org.jsoup.nodes.Element persons = scrape.select("body :contains(PERSONS)").last();
            if (persons != null && persons.tagName().equals("h2")) {
                persons = persons.nextElementSibling();
                //ALL CHARACTERS IN ONE <P> FORMAT
                if (persons.tagName().equals("p")) {
                    String characters = persons.text();
                    Characters.appendChild(document.createTextNode(characters));
                    System.out.println("Characters of Play: " + "\n" + characters);
                    Play.appendChild(Characters);
                }
            }
            //CHARACTERS REPRESENTED FORMAT
            org.jsoup.nodes.Element represented = scrape.select("body :contains(CHARACTERS REPRESENTED)").first();
            if (represented != null) {
                represented = represented.nextElementSibling();
                //ALL CHARACTERS IN ONE <UL> FORMAT
                if (represented.tagName().equals("ul")) {
                    String characters = represented.text();
                    Characters.appendChild(document.createTextNode(characters));
                    System.out.println("Characters of Play: " + "\n" + characters);
                    Play.appendChild(Characters);
                }
            }
            System.out.println("\n" + "------------------------------------------" + "\n");

            //MAIN PLAY
            actNumber = 0;
            sceneNumber = 0;
            scenes = 0;

            //<DIV CLASS="CHAPTER"> INSIDE ANOTHER <DIV CLASS="CHAPTER"> FOR EACH ACT FORMAT
            org.jsoup.nodes.Element nestedChapterPerAct = scrape.select("h2#act1").first();
            //<DIV CLASS="CHAPTER"> PER ACT FORMAT
            org.jsoup.nodes.Element chapterPerAct = scrape.selectFirst("div.chapter :contains(ACT I)");
            //<DIV CLASS="CHAPTER"> PER ACT FORMAT (ACT ONE)
            org.jsoup.nodes.Element chapterPerActOne = scrape.selectFirst("div.chapter :contains(ACT ONE)");
            //FIRST ACT FORMAT
            org.jsoup.nodes.Element firstAct = scrape.select("body :contains(FIRST ACT)").first();
            //ACT I THAT IS INSIDE <H2> FORMAT
            org.jsoup.nodes.Element actI = scrape.select("h2 :contains(ACT I)").first();
            //ACT I THAT IS DIRECTLY <H2> FORMAT
            //org.jsoup.nodes.Element actOwn = scrape.select("h2:containsOwn(ACT I)").first();
            //ACT I THAT IS <H2> FORMAT
            org.jsoup.nodes.Element actH2 = scrape.select("body :contains(ACT I)").first();

            if (nestedChapterPerAct != null) {
                System.out.println("\n<DIV CLASS=\"CHAPTER\"> INSIDE ANOTHER <DIV CLASS=\"CHAPTER\"> FOR EACH ACT FORMAT \n");
                org.jsoup.nodes.Element act = nestedChapterPerAct;

                while (act != null) {
                    if (act.hasAttr("id")) {
                        //ACT
                        Act = document.createElement("Πράξη");
                        actNumber++;
                        System.out.println("ACT " + actNumber + "\n");
                        Act.setAttribute("Νούμερο", String.valueOf(actNumber));
                    }
                    if (act.tagName().equals("p")) {
                        //STAGE DIRECTIONS
                        if (act.hasClass("noindent") || act.hasClass("stage")) {
                            StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                            StageDirections.appendChild(document.createTextNode(act.text().replaceAll("\\[", "").replaceAll("\\]", "")));
                            System.out.println("Stage Directions: " + act.text() + "\n");
                            Act.appendChild(StageDirections);
                        } else if (act.hasClass("dialog")) {
                            //CHARACTER
                            Character = document.createElement("Χαρακτήρας");
                            //CHARACTER NAME
                            CharacterName = document.createElement("Όνομα");
                            String fix = act.text().replaceAll("THE DAUGHTER", "THE DAUGHTER.").replaceAll("THE MOTHER", "THE MOTHER.")
                                    .replaceAll("A BYSTANDER", "A BYSTANDER.").replaceAll("THE FLOWER GIRL", "THE FLOWER GIRL.")
                                    .replaceAll("THE BYSTANDER", "THE BYSTANDER.").replaceAll("THE NOTE TAKER", "THE NOTE TAKER.")
                                    .replaceAll("THE BYSTANDERS GENERALLY", "THE BYSTANDERS GENERALLY.").replaceAll("THE GENTLEMAN", "THE GENTLEMAN.")
                                    .replaceAll("A SARCASTIC BYSTANDER", "A SARCASTIC BYSTANDER.").replaceAll("THE SARCASTIC BYSTANDER", "THE SARCASTIC BYSTANDER.")
                                    .replaceAll("THE SARCASTIC ONE", "THE SARCASTIC ONE.").replaceAll("SEVERAL BYSTANDERS", "SEVERAL BYSTANDERS.")
                                    .replaceAll("PICKERING", "PICKERING.").replaceAll("HIGGINS", "HIGGINS.").replaceAll("FREDDY", "FREDDY.")
                                    .replaceAll("PEARCE", "PEARCE.").replaceAll("LIZA", "LIZA.")
                                    .replaceAll("DOOLITTLE", "DOOLITTLE.").replaceAll("EYNSFORD HILL", "EYNSFORD HILL.")
                                    .replaceAll("Miss EYNSFORD HILL", "MISS EYNSFORD HILL").replaceAll("MISS EYNSFORD HILL", "MRS. EYNSFORD HILL.")
                                    .replaceAll("THE PARLOR-MAID", "THE PARLOR-MAID.").replaceAll("CLARA", "CLARA.")
                                    .replaceAll("THE BYSTANDER.", "A BYSTANDER.").replaceAll("THE GENTLEMEN.", "THE GENTLEMAN.")
                                    .replaceAll("THE SARCASTIC BYSTANDER", "A SARCASTIC BYSTANDER").replaceAll("THE SARCASTIC ONE", "A SARCASTIC BYSTANDER")
                                    .replaceAll("MRS.", "MRS");
                            fix = fix.replaceAll("\\..", "\\.");
                            if (act.text().contains("Liza opens her mouth")) {
                                fix = "LIZA. " + act.text();
                            } else if (act.text().contains("He hurries to the door")) {
                                fix = "DOOLITTLE. " + act.text();
                            } else if (act.text().contains("They are interrupted by the")) {
                                fix = "THE PARLOR-MAID. " + act.text();
                            } else if (act.text().contains("Pickering gasps and sits down")) {
                                fix = "PICKERING. " + act.text();
                            }
                            String name = fix.substring(0, fix.indexOf(".") + 1).replaceAll("\\.", "");
                            System.out.println("Character: " + name + "\n");
                            if (charList.contains(name)) {
                                id = charList.indexOf(name) + 1;
                                Character.setAttribute("id", String.valueOf(id));
                            } else {
                                charList.add(name);
                                characterID++;
                                Character.setAttribute("id", String.valueOf(characterID));
                            }
                            CharacterName.appendChild(document.createTextNode(name));
                            Character.appendChild(CharacterName);
                            Act.appendChild(Character);

                            String str = fix.substring(fix.indexOf(".") + 1, fix.length()).trim();
                            str = str.replaceAll("\\].", "\\.]");
                            if (str.contains("[")) {
                                //Split the string into Stage directions and Speech
                                String[] parts = str.split("(?<=])|(?=\\[)");

                                for (String s : parts) {
                                    //CHARACTER STAGE DIRECTIONS
                                    if (s.contains("[")) {
                                        s = s.replaceAll("\\[", "").replaceAll("\\]", "");
                                        System.out.println("Stage Directions: " + s + "\n");
                                        StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                                        StageDirections.appendChild(document.createTextNode(s));
                                        Character.appendChild(StageDirections);
                                    } else {
                                        //CAHARACTER SPEECH
                                        System.out.println("Speech: " + s + "\n");
                                        Speech = document.createElement("Λόγος");
                                        Speech.appendChild(document.createTextNode(s));
                                        Character.appendChild(Speech);
                                        Act.appendChild(Character);
                                    }
                                }
                            } else {
                                //CHARACTER SPEECH ONLY
                                System.out.println("Speech: " + str + "\n");
                                Speech = document.createElement("Λόγος");
                                Speech.appendChild(document.createTextNode(str));
                                Character.appendChild(Speech);
                                Act.appendChild(Character);
                            }
                        }
                    }
                    Play.appendChild(Act);
                    act = act.nextElementSibling();
                }
            } else if (chapterPerAct != null) {
                System.out.println("\n<DIV CLASS=\"CHAPTER\"> PER ACT FORMAT \n");
                org.jsoup.nodes.Element next = chapterPerAct.nextElementSibling();

                //<DIV CLASS="CHAPTER"> PER ACT FORMAT (ELEMENTS ARE WITHIN THE <DIV CLASS="CHAPTER">)
                if (next != null) {
                    System.out.println("ELEMENTS ARE WITHIN THE <DIV CLASS=\"CHAPTER\">");
                    org.jsoup.nodes.Element act = chapterPerAct;
                    org.jsoup.nodes.Element div = chapterPerAct.parent();

                    while (div != null && div.hasClass("chapter")) {
                        //Get 1st child element
                        act = div.child(0);
                        //ACT
                        if (act.text().contains("ACT")) {
                            Act = document.createElement("Πράξη");
                            actNumber++;
                            System.out.println("ACT " + actNumber + "\n");
                            Act.setAttribute("Νούμερο", String.valueOf(actNumber));
                            sceneNumber = 0;
                        } else {
                            act = act.nextElementSibling();
                            if (act.text().contains("ACT")) {
                                Act = document.createElement("Πράξη");
                                actNumber++;
                                System.out.println("ACT " + actNumber + "\n");
                                Act.setAttribute("Νούμερο", String.valueOf(actNumber));
                                sceneNumber = 0;
                            }
                        }
                        if (!act.text().contains("ACT")) {
                            break;
                        }

                        //Until last element 
                        while (act != null && !act.text().contains("THE PLAYBOY OF")) {
                            //SCENE
                            if (act.text().contains("SCENE")) {
                                Scene = document.createElement("Σκηνή");
                                sceneNumber++;
                                System.out.println("Scene " + sceneNumber + "\n");
                                Scene.setAttribute("Νούμερο", String.valueOf(sceneNumber));
                                scenes++;
                            }
                            //<P> ELEMENT
                            if (act.tagName().equals("p") && act.hasText()) {
                                //STAGE DIRECTIONS
                                if (act.hasClass("scenedesc") || act.hasClass("right") || act.hasClass("center")) {
                                    StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                                    StageDirections.appendChild(document.createTextNode(act.text().replaceAll("\\[", "").replaceAll("\\]", "")));
                                    System.out.println("Stage Directions: " + act.text() + "\n");
                                    Scene.appendChild(StageDirections);
                                } else if ((!act.html().contains("<br>"))) {
                                    StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                                    StageDirections.appendChild(document.createTextNode(act.text().replaceAll("\\[", "").replaceAll("\\]", "")));
                                    System.out.println("StageDirections: " + act.text() + "\n");
                                    Scene.appendChild(StageDirections);
                                } else {
                                    //CHARACTER
                                    Character = document.createElement("Χαρακτήρας");
                                    //CHARACTER NAME
                                    CharacterName = document.createElement("Όνομα");
                                    String fix = act.text().replaceAll("BARNARDO", "BARNARDO.").replaceAll("But, soft,", "HORATIO. But, soft,")
                                            .replaceAll("Stop it, Marcellus", "HORATIO. Stop it, Marcellus")
                                            .replaceAll("And now, Laertes", "KING. And now, Laertes").replaceAll("Welcome, my", "KING. Welcome, my")
                                            .replaceAll("Mar. and BARNARDO.", "MARCELLUS and BARNARDO.").replaceAll("Both.", "BOTH.")
                                            .replaceAll("My father’s spirit", "HAMLET. My father’s spirit").replaceAll("A double blessing", "LAERTES. A double blessing")
                                            .replaceAll("And these few", "POLONIUS. And these few").replaceAll("By heaven, I’ll make", "HAMLET. By heaven, I’ll make")
                                            .replaceAll("So, uncle", "HAMLET. So, uncle").replaceAll("He tells me", "KING. He tells me").replaceAll("All. ", "ALL. ")
                                            .replaceAll("’Tis now the", "HAMLET. ’Tis now the").replaceAll("O, my offence", "KING. O, my offence")
                                            .replaceAll("Friends both", "KING. Friends both").replaceAll("Come, Gertrude", "KING. Come, Gertrude")
                                            .replaceAll("And England,", "KING. And England,").replaceAll("How all occasions", "HAMLET. How all occasions")
                                            .replaceAll("To my sick", "QUEEN. To my sick").replaceAll("Then up", "OPHELIA. Then up").replaceAll("Quoth she", "OPHELIA. Quoth she")
                                            .replaceAll("O, this is the", "KING. O, this is the").replaceAll("Danes.", "DANES.").replaceAll("O heat", "LAERTES. O heat")
                                            .replaceAll("His beard was as", "OPHELIA. His beard was as").replaceAll("I do not know from", "HORATIO. I do not know from")
                                            .replaceAll("Come, I will", "HORATIO. Come, I will").replaceAll("In youth", "FIRST CLOWN. In youth")
                                            .replaceAll("The Queen, the", "HAMLET. The Queen, the").replaceAll("\\[Reads.\\] ‘High", "KING. \\[Reads.\\] ‘High")
                                            .replaceAll("Come. Another", "HAMLET. Come. Another").replaceAll("\\[To Laertes\\]", "KING. \\[To Laertes\\]")
                                            .replaceAll("Dost thou hear me", "HAMLET. Dost thou hear me").replaceAll("How now, Ophelia,", "POLONIUS. How now, Ophelia,")
                                            .replaceAll("How now, my lord", "HAMLET. How now, my lord").replaceAll("How now? What news?", "KING. How now? What news?")
                                            .replaceAll("How now? What hath", "KING. How now? What hath").replaceAll("Save me and", "HAMLET. Save me and")
                                            .replaceAll("What should this mean", "KING. What should this mean").replaceAll("SARAH", "SARAH.").replaceAll("SUSAN", "SUSAN.")
                                            .replaceAll("There we lay", "MICHAEL. There we lay").replaceAll("SARA.", "SARAH.").replaceAll("SARA TANSEY.", "SARAH.")
                                            .replaceAll("SHAWN KEOGH.", "SHAWN.").replaceAll("DOCTOR RANK.", "RANK.").replaceAll("THE CHILDREN.", "CHILDREN.");
                                    String name = fix.substring(0, fix.indexOf(".") + 1).replaceAll("\\.", "");
                                    System.out.println("Character: " + name + "\n");
                                    if (charList.contains(name)) {
                                        id = charList.indexOf(name) + 1;
                                        Character.setAttribute("id", String.valueOf(id));
                                    } else {
                                        charList.add(name);
                                        characterID++;
                                        Character.setAttribute("id", String.valueOf(characterID));
                                    }
                                    CharacterName.appendChild(document.createTextNode(name));
                                    Character.appendChild(CharacterName);
                                    Scene.appendChild(Character);

                                    String str = act.text().substring(act.text().indexOf(".") + 1, act.text().length()).trim();
                                    str = str.replaceAll("\\(", "\\[").replaceAll("\\)", "\\]").trim();
                                    if (str.contains("[")) {
                                        //Split the string into Stage directions and Speech
                                        String[] parts = str.split("(?<=])|(?=\\[)");

                                        for (String s : parts) {
                                            //CHARACTER STAGE DIRECTIONS
                                            if (s.contains("[")) {
                                                s = s.replaceAll("\\[", "").replaceAll("\\]", "");
                                                System.out.println("Stage Directions: " + s + "\n");
                                                StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                                                StageDirections.appendChild(document.createTextNode(s));
                                                Character.appendChild(StageDirections);
                                            } else {
                                                //CAHARACTER SPEECH
                                                if (s.startsWith(". ")) {
                                                    s = s.replaceAll("\\. ", "").trim();
                                                }
                                                s = s.trim();
                                                System.out.println("Speech: " + s + "\n");
                                                Speech = document.createElement("Λόγος");
                                                Speech.appendChild(document.createTextNode(s));
                                                Character.appendChild(Speech);
                                                Scene.appendChild(Character);
                                            }
                                        }
                                    } else {
                                        //CHARACTER SPEECH ONLY
                                        System.out.println("Speech: " + str.trim() + "\n");
                                        Speech = document.createElement("Λόγος");
                                        Speech.appendChild(document.createTextNode(str.trim()));
                                        Character.appendChild(Speech);
                                        Scene.appendChild(Character);
                                    }
                                }
                                Act.appendChild(Scene);
                            }
                            act = act.nextElementSibling();
                        }
                        Play.appendChild(Act);
                        div = div.nextElementSibling();
                    }
                } //<DIV CLASS="CHAPTER"> PER ACT FORMAT (ELEMENTS ARE NOT WITHIN THE <DIV CLASS="CHAPTER">)
                else {
                    System.out.println("ELEMENTS ARE NOT WITHIN THE <DIV CLASS=\"CHAPTER\">");
                    org.jsoup.nodes.Element act = chapterPerAct.parent();

                    while (!act.text().contains("PROPERTY LIST") && !act.text().contains("THE END")) {
                        //ACT
                        if (act.hasClass("chapter")) {
                            Act = document.createElement("Πράξη");
                            actNumber++;
                            System.out.println("ACT " + actNumber + "\n");
                            Act.setAttribute("Νούμερο", String.valueOf(actNumber));
                            sceneNumber = 0;
                        }
                        //SCENE
                        if (act.text().contains("Scene ")) {
                            Scene = document.createElement("Σκηνή");
                            sceneNumber++;
                            System.out.println("Scene " + sceneNumber + "\n");
                            Scene.setAttribute("Νούμερο", String.valueOf(sceneNumber));
                            scenes++;
                        }
                        //STAGE DIRECTIONS
                        if (act.tagName().equals("div") && act.hasClass("scene")) {
                            StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                            StageDirections.appendChild(document.createTextNode(act.text().replaceAll("\\[", "").replaceAll("\\]", "")));
                            System.out.println("Stage Directions: " + act.text() + "\n");
                            if (Scene != null) {
                                Scene.appendChild(StageDirections);
                            } else {
                                Act.appendChild(StageDirections);
                            }
                        }
                        //STAGE DIRECTIONS
                        if (act.tagName().equals("blockquote")) {
                            StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                            StageDirections.appendChild(document.createTextNode(act.text().replaceAll("\\[", "").replaceAll("\\]", "")));
                            System.out.println("Stage Directions: " + act.text() + "\n");
                            //Act.appendChild(StageDirections);
                            if (Scene != null) {
                                Scene.appendChild(StageDirections);
                            } else {
                                Act.appendChild(StageDirections);
                            }
                        }
                        if (act.tagName().equals("table")) {
                            org.jsoup.nodes.Element tr = act.select("tr").first();
                            System.out.println("First tr: " + tr);

                            while (tr != null) {
                                //CHARACTER
                                Character = document.createElement("Χαρακτήρας");
                                //CHARACTER NAME
                                CharacterName = document.createElement("Όνομα");
                                String fix = tr.text().replaceAll("Dr.", "Dr");
                                String name = fix.substring(0, fix.indexOf(".") + 1).replaceAll("\\.", "");
                                System.out.println("Character: " + name + "\n");
                                if (charList.contains(name)) {
                                    id = charList.indexOf(name) + 1;
                                    Character.setAttribute("id", String.valueOf(id));
                                } else {
                                    charList.add(name);
                                    characterID++;
                                    Character.setAttribute("id", String.valueOf(characterID));
                                }
                                CharacterName.appendChild(document.createTextNode(name));
                                Character.appendChild(CharacterName);
                                //Act.appendChild(Character);
                                if (Scene != null) {
                                    Scene.appendChild(Character);
                                } else {
                                    Act.appendChild(Character);
                                }

                                String str = fix.substring(fix.indexOf(".") + 1, fix.length()).trim();
                                str = str.replaceAll("\\(", "\\[").replaceAll("\\)", "\\]");
                                if (str.contains("[")) {
                                    //Split the string into Stage directions and Speech
                                    String[] parts = str.split("(?<=])|(?=\\[)");

                                    for (String s : parts) {
                                        //CHARACTER STAGE DIRECTIONS
                                        if (s.contains("[")) {
                                            s = s.replaceAll("\\[", "").replaceAll("\\]", "").trim();
                                            System.out.println("Stage Directions: " + s + "\n");
                                            StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                                            StageDirections.appendChild(document.createTextNode(s));
                                            Character.appendChild(StageDirections);
                                        } else {
                                            //CAHARACTER SPEECH
                                            System.out.println("Speech: " + s + "\n");
                                            Speech = document.createElement("Λόγος");
                                            Speech.appendChild(document.createTextNode(s));
                                            Character.appendChild(Speech);
                                            //Act.appendChild(Character);
                                            if (Scene != null) {
                                                Scene.appendChild(Character);
                                            } else {
                                                Act.appendChild(Character);
                                            }
                                        }
                                    }
                                } else {
                                    //CHARACTER SPEECH ONLY
                                    System.out.println("Speech: " + str + "\n");
                                    Speech = document.createElement("Λόγος");
                                    Speech.appendChild(document.createTextNode(str));
                                    Character.appendChild(Speech);
                                    //Act.appendChild(Character);
                                    if (Scene != null) {
                                        Scene.appendChild(Character);
                                    } else {
                                        Act.appendChild(Character);
                                    }
                                }
                                tr = tr.nextElementSibling();
                            }
                        }
                        if (act.tagName().equals("p")) {
                            //STAGE DIRECTIONS
                            if (act.hasClass("center") || act.hasClass("right") || act.hasClass("enter") || act.hasClass("exit") || act.hasClass("direction")) {
                                StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                                StageDirections.appendChild(document.createTextNode(act.text().replaceAll("\\[", "").replaceAll("\\]", "")));
                                System.out.println("Stage Directions: " + act.text() + "\n");
                                //Act.appendChild(StageDirections);
                                if (Scene != null) {
                                    Scene.appendChild(StageDirections);
                                } else {
                                    Act.appendChild(StageDirections);
                                }
                            } else if (act.hasText() && !act.text().contains("[") && !act.hasClass("bottom-three")) {
                                //CHARACTER
                                Character = document.createElement("Χαρακτήρας");
                                //CHARACTER NAME
                                CharacterName = document.createElement("Όνομα");
                                String fix = act.text().replaceAll("Helena", "Helena.").replaceAll("Gall", "Gall.").replaceAll("Dr.", "Dr")
                                        .replaceAll("Mrs.", "Mrs").replaceAll("Mr.", "Mr").replaceAll("We mistresses", "Mrs G. We mistresses")
                                        .replaceAll("I am to have", "Mrs G. I am to have").replaceAll("I am glad to see you,", "Glen. I am glad to see you,")
                                        .replaceAll("Oh, how happy", "Melinda. Oh, how happy").replaceAll("But she must be sure", "Mr P. But she must be sure")
                                        .replaceAll("Why, how do you do, Squire", "Walk. Why, how do you do, Squire").replaceAll("Why, how do you do, Mr Pinchen", "Walk. Why, how do you do, Mr Pinchen")
                                        .replaceAll("Ah! my dear, I am glad you’ve come, I’ve been", "Dr G. Ah! my dear, I am glad you’ve come, I’ve been")
                                        .replaceAll("Ah! my dear, I am glad you’ve come.", "Dr Gaines. Ah! my dear, I am glad you’ve come.")
                                        .replaceAll("That man is enough", "Mrs Gaines. That man is enough").replaceAll("Good ebenin", "Cato. Good ebenin")
                                        .replaceAll("Dr Gaines, (in a low voice)", "Dr Gaines. (in a low voice)").replaceAll("I am glad that the Colonel", "Mrs G. I am glad that the Colonel")
                                        .replaceAll("Hannah needn’t", "Cato. Hannah needn’t").replaceAll("Walk in, sir", "Hannah. Walk in, sir")
                                        .replaceAll("That is one of the niggers", "Mrs G. That is one of the niggers").replaceAll("I have sent for you,", "Dr Gaines. I have sent for you,")
                                        .replaceAll("This will never do.", "Dr G. This will never do.").replaceAll("With the thoughts of", "Glen. With the thoughts of")
                                        .replaceAll("I think, Simeon", "Mrs Neal. I think, Simeon").replaceAll("I am glad those fellows", "Mr White. I am glad those fellows")
                                        .replaceAll("Dr G.", "Dr Gaines.").replaceAll("Mr G.", "Dr Gaines.").replaceAll("Mr Gaines.", "Dr Gaines.").replaceAll("Mr C.", "Mr Campbell.")
                                        .replaceAll("Mrs G.", "Mrs Gaines.").replaceAll("Mr P.", "Mr Pinchen.").replaceAll("Walk.", "Walker.").replaceAll("Wild.", "Wildmarsh.")
                                        .replaceAll("Mr N", "Mr Neal.").replaceAll("Samp.", "Sampey.").replaceAll("1st Loun.", "1st Lounger.").replaceAll("Tap.", "Tapioca.")
                                        .replaceAll("Hand me my fan", "Mrs Gaines. Hand me my fan").replaceAll("Mr White.", "White.").replaceAll("White.", "Mr White.")
                                        .replaceAll("And so thee wants", "Mr Neal. And so thee wants");
                                fix = fix.replaceAll("\\..", "\\.").replaceAll("’", "'");
                                String name = fix.substring(0, fix.indexOf(".") + 1).replaceAll("\\.", "");
                                System.out.println("Character: " + name + "\n");
                                if (charList.contains(name)) {
                                    id = charList.indexOf(name) + 1;
                                    Character.setAttribute("id", String.valueOf(id));
                                } else {
                                    charList.add(name);
                                    characterID++;
                                    Character.setAttribute("id", String.valueOf(characterID));
                                }
                                CharacterName.appendChild(document.createTextNode(name));
                                Character.appendChild(CharacterName);
                                //Act.appendChild(Character);
                                if (Scene != null) {
                                    Scene.appendChild(Character);
                                } else {
                                    Act.appendChild(Character);
                                }

                                String str = fix.substring(fix.indexOf(".") + 1, fix.length()).trim();
                                str = str.replaceAll("\\(", "\\[").replaceAll("\\)", "\\]");
                                if (str.contains("[")) {
                                    //Split the string into Stage directions and Speech
                                    String[] parts = str.split("(?<=])|(?=\\[)");

                                    for (String s : parts) {
                                        //CHARACTER STAGE DIRECTIONS
                                        if (s.contains("[")) {
                                            s = s.replaceAll("\\[", "").replaceAll("\\]", "").trim();
                                            System.out.println("Stage Directions: " + s + "\n");
                                            StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                                            StageDirections.appendChild(document.createTextNode(s));
                                            Character.appendChild(StageDirections);
                                        } else {
                                            //CAHARACTER SPEECH
                                            System.out.println("Speech: " + s.trim() + "\n");
                                            Speech = document.createElement("Λόγος");
                                            Speech.appendChild(document.createTextNode(s.trim()));
                                            Character.appendChild(Speech);
                                            //Act.appendChild(Character);
                                            if (Scene != null) {
                                                Scene.appendChild(Character);
                                            } else {
                                                Act.appendChild(Character);
                                            }
                                        }
                                    }
                                } else {
                                    //CHARACTER SPEECH ONLY
                                    System.out.println("Speech: " + str + "\n");
                                    Speech = document.createElement("Λόγος");
                                    Speech.appendChild(document.createTextNode(str));
                                    Character.appendChild(Speech);
                                    //Act.appendChild(Character);
                                    if (Scene != null) {
                                        Scene.appendChild(Character);
                                    } else {
                                        Act.appendChild(Character);
                                    }
                                }
                            }
                            if (Scene != null) {
                                Act.appendChild(Scene);
                            }
                        }
                        Play.appendChild(Act);
                        act = act.nextElementSibling();
                    }
                }
            } else if (chapterPerActOne != null) {
                System.out.println("ELEMENTS ARE NOT WITHIN THE <DIV CLASS=\"CHAPTER\">");
                org.jsoup.nodes.Element act = chapterPerActOne.parent();
                System.out.println(act);

                while (!act.text().contains("PROPERTY LIST") && !act.text().contains("THE END")) {
                    //ACT
                    if (act.hasClass("chapter")) {
                        Act = document.createElement("Πράξη");
                        actNumber++;
                        System.out.println("ACT " + actNumber + "\n");
                        Act.setAttribute("Νούμερο", String.valueOf(actNumber));
                        sceneNumber = 0;
                    }
                    //SCENE
                    if (act.text().contains("Scene")) {
                        Scene = document.createElement("Σκηνή");
                        sceneNumber++;
                        System.out.println("Scene " + sceneNumber + "\n");
                        Scene.setAttribute("Νούμερο", String.valueOf(sceneNumber));
                        scenes++;
                    }
                    //STAGE DIRECTIONS
                    if (act.tagName().equals("div") && act.hasClass("scene")) {
                        StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                        StageDirections.appendChild(document.createTextNode(act.text().replaceAll("\\[", "").replaceAll("\\]", "")));
                        System.out.println("Stage Directions: " + act.text() + "\n");
                        Scene.appendChild(StageDirections);
                    }
                    //STAGE DIRECTIONS
                    if (act.tagName().equals("blockquote")) {
                        StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                        StageDirections.appendChild(document.createTextNode(act.text().replaceAll("\\[", "").replaceAll("\\]", "")));
                        System.out.println("Stage Directions: " + act.text() + "\n");
                        Scene.appendChild(StageDirections);
                    }
                    if (act.tagName().equals("table")) {
                        org.jsoup.nodes.Element tr = act.select("tr").first();
                        System.out.println("First tr: " + tr);

                        while (tr != null) {
                            //CHARACTER
                            Character = document.createElement("Χαρακτήρας");
                            //CHARACTER NAME
                            CharacterName = document.createElement("Όνομα");
                            String fix = tr.text().replaceAll("Dr.", "Dr");
                            String name = fix.substring(0, fix.indexOf(".") + 1).replaceAll("\\.", "");
                            System.out.println("Character: " + name + "\n");
                            if (charList.contains(name)) {
                                id = charList.indexOf(name) + 1;
                                Character.setAttribute("id", String.valueOf(id));
                            } else {
                                charList.add(name);
                                characterID++;
                                Character.setAttribute("id", String.valueOf(characterID));
                            }
                            CharacterName.appendChild(document.createTextNode(name));
                            Character.appendChild(CharacterName);
                            Scene.appendChild(Character);

                            String str = fix.substring(fix.indexOf(".") + 1, fix.length()).trim();
                            str = str.replaceAll("\\(", "\\[").replaceAll("\\)", "\\]");
                            if (str.contains("[")) {
                                //Split the string into Stage directions and Speech
                                String[] parts = str.split("(?<=])|(?=\\[)");

                                for (String s : parts) {
                                    //CHARACTER STAGE DIRECTIONS
                                    if (s.contains("[")) {
                                        s = s.replaceAll("\\[", "").replaceAll("\\]", "").trim();
                                        System.out.println("Stage Directions: " + s + "\n");
                                        StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                                        StageDirections.appendChild(document.createTextNode(s));
                                        Character.appendChild(StageDirections);
                                    } else {
                                        //CAHARACTER SPEECH
                                        System.out.println("Speech: " + s + "\n");
                                        Speech = document.createElement("Λόγος");
                                        Speech.appendChild(document.createTextNode(s));
                                        Character.appendChild(Speech);
                                        Scene.appendChild(Character);

                                    }
                                }
                            } else {
                                //CHARACTER SPEECH ONLY
                                System.out.println("Speech: " + str + "\n");
                                Speech = document.createElement("Λόγος");
                                Speech.appendChild(document.createTextNode(str));
                                Character.appendChild(Speech);
                                Scene.appendChild(Character);
                            }
                            tr = tr.nextElementSibling();
                        }
                    }
                    if (act.tagName().equals("p")) {
                        //STAGE DIRECTIONS
                        if (act.hasClass("center") || act.hasClass("right") || act.hasClass("enter") || act.hasClass("exit") || act.hasClass("direction")) {
                            StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                            StageDirections.appendChild(document.createTextNode(act.text().replaceAll("\\[", "").replaceAll("\\]", "")));
                            System.out.println("Stage Directions: " + act.text() + "\n");
                            Scene.appendChild(StageDirections);
                        } else if (act.hasText() && !act.text().contains("[") && !act.hasClass("bottom-three")) {
                            //CHARACTER
                            Character = document.createElement("Χαρακτήρας");
                            //CHARACTER NAME
                            CharacterName = document.createElement("Όνομα");
                            String fix = act.text().replaceAll("Helena", "Helena.").replaceAll("Gall", "Gall.").replaceAll("Dr.", "Dr")
                                    .replaceAll("Mrs.", "Mrs").replaceAll("Mr.", "Mr").replaceAll("We mistresses", "Mrs G. We mistresses")
                                    .replaceAll("I am to have", "Mrs G. I am to have").replaceAll("I am glad to see you,", "Glen. I am glad to see you,")
                                    .replaceAll("Oh, how happy", "Melinda. Oh, how happy").replaceAll("But she must be sure", "Mr P. But she must be sure")
                                    .replaceAll("Why, how do you do, Squire", "Walk. Why, how do you do, Squire").replaceAll("Why, how do you do, Mr Pinchen", "Walk. Why, how do you do, Mr Pinchen")
                                    .replaceAll("Ah! my dear, I am glad you’ve come, I’ve been", "Dr G. Ah! my dear, I am glad you’ve come, I’ve been")
                                    .replaceAll("Ah! my dear, I am glad you’ve come.", "Dr Gaines. Ah! my dear, I am glad you’ve come.")
                                    .replaceAll("That man is enough", "Mrs Gaines. That man is enough").replaceAll("Good ebenin", "Cato. Good ebenin")
                                    .replaceAll("Dr Gaines, (in a low voice)", "Dr Gaines. (in a low voice)").replaceAll("I am glad that the Colonel", "Mrs G. I am glad that the Colonel")
                                    .replaceAll("Hannah needn’t", "Cato. Hannah needn’t").replaceAll("Walk in, sir", "Hannah. Walk in, sir")
                                    .replaceAll("That is one of the niggers", "Mrs G. That is one of the niggers").replaceAll("I have sent for you,", "Dr Gaines. I have sent for you,")
                                    .replaceAll("This will never do.", "Dr G. This will never do.").replaceAll("With the thoughts of", "Glen. With the thoughts of")
                                    .replaceAll("I think, Simeon", "Mrs Neal. I think, Simeon").replaceAll("I am glad those fellows", "Mr White. I am glad those fellows")
                                    .replaceAll("Dr G.", "Dr Gaines.").replaceAll("Mr G.", "Dr Gaines.").replaceAll("Mr Gaines.", "Dr Gaines.").replaceAll("Mr C.", "Mr Campbell.")
                                    .replaceAll("Mrs G.", "Mrs Gaines.").replaceAll("Mr P.", "Mr Pinchen.").replaceAll("Walk.", "Walker.").replaceAll("Wild.", "Wildmarsh.")
                                    .replaceAll("Mr N", "Mr Neal.").replaceAll("Samp.", "Sampey.").replaceAll("1st Loun.", "1st Lounger.").replaceAll("Tap.", "Tapioca.")
                                    .replaceAll("Hand me my fan", "Mrs Gaines. Hand me my fan").replaceAll("Mr White.", "White.").replaceAll("White.", "Mr White.")
                                    .replaceAll("And so thee wants", "Mr Neal. And so thee wants");
                            fix = fix.replaceAll("\\..", "\\.").replaceAll("’", "'");
                            String name = fix.substring(0, fix.indexOf(".") + 1).replaceAll("\\.", "");
                            System.out.println("Character: " + name + "\n");
                            if (charList.contains(name)) {
                                id = charList.indexOf(name) + 1;
                                Character.setAttribute("id", String.valueOf(id));
                            } else {
                                charList.add(name);
                                characterID++;
                                Character.setAttribute("id", String.valueOf(characterID));
                            }
                            CharacterName.appendChild(document.createTextNode(name));
                            Character.appendChild(CharacterName);
                            Scene.appendChild(Character);

                            String str = fix.substring(fix.indexOf(".") + 1, fix.length()).trim();
                            str = str.replaceAll("\\(", "\\[").replaceAll("\\)", "\\]");
                            if (str.contains("[")) {
                                //Split the string into Stage directions and Speech
                                String[] parts = str.split("(?<=])|(?=\\[)");

                                for (String s : parts) {
                                    //CHARACTER STAGE DIRECTIONS
                                    if (s.contains("[")) {
                                        s = s.replaceAll("\\[", "").replaceAll("\\]", "").trim();
                                        System.out.println("Stage Directions: " + s + "\n");
                                        StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                                        StageDirections.appendChild(document.createTextNode(s));
                                        Character.appendChild(StageDirections);
                                    } else {
                                        //CAHARACTER SPEECH
                                        System.out.println("Speech: " + s.trim() + "\n");
                                        Speech = document.createElement("Λόγος");
                                        Speech.appendChild(document.createTextNode(s.trim()));
                                        Character.appendChild(Speech);
                                        Scene.appendChild(Character);
                                    }
                                }
                            } else {
                                //CHARACTER SPEECH ONLY
                                System.out.println("Speech: " + str + "\n");
                                Speech = document.createElement("Λόγος");
                                Speech.appendChild(document.createTextNode(str));
                                Character.appendChild(Speech);
                                Scene.appendChild(Character);
                            }
                        }
                        Act.appendChild(Scene);
                    }
                    Play.appendChild(Act);
                    act = act.nextElementSibling();
                }
            } else if (firstAct != null) {
                System.out.println("\nFIRST ACT FORMAT \n");
                org.jsoup.nodes.Element act = firstAct;

                //<P> ELEMENTS ONE AFTER ANOTHER
                while (!act.tagName().equals("div")) {
                    //ACT
                    if (act.text().contains("ACT")) {
                        Act = document.createElement("Πράξη");
                        actNumber++;
                        System.out.println("Act " + actNumber + "\n");
                        Act.setAttribute("Νούμερο", String.valueOf(actNumber));
                        sceneNumber = 0;
                    }
                    //SCENE
                    if (act.text().contains("SCENE")) {
                        Scene = document.createElement("Σκηνή");
                        sceneNumber++;
                        System.out.println("Scene " + sceneNumber + "\n");
                        Scene.setAttribute("Νούμερο", String.valueOf(sceneNumber));
                        scenes++;
                    }
                    if (act.tagName().equals("p") && act.hasText()) {
                        //STAGE DIRECTIONS
                        if (act.text().startsWith("[")) {
                            System.out.println("Stage Directions: " + act.text() + "\n");
                            StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                            StageDirections.appendChild(document.createTextNode(act.text().replaceAll("\\[", "").replaceAll("\\]", "")));
                            Scene.appendChild(StageDirections);
                        } else if (act.child(0).tagName().equals("i")) {
                            System.out.println("Stage Directions: " + act.text() + "\n");
                            StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                            StageDirections.appendChild(document.createTextNode(act.text()));
                            Scene.appendChild(StageDirections);
                        } else if (act.hasAttr("style")) {
                            System.out.println("Stage Directions: " + act.text() + "\n");
                            StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                            StageDirections.appendChild(document.createTextNode(act.text()));
                            Scene.appendChild(StageDirections);
                        } else {
                            //CHARACTER
                            Character = document.createElement("Χαρακτήρας");
                            CharacterName = document.createElement("Όνομα");
                            //CHARACTER NAME
                            if (act.child(0).tagName().equals("span")) {
                                String name = act.child(0).text().trim();
                                System.out.println("Character: " + name + "\n");
                                if (charList.contains(name)) {
                                    id = charList.indexOf(name) + 1;
                                    Character.setAttribute("id", String.valueOf(id));
                                } else {
                                    charList.add(name);
                                    characterID++;
                                    Character.setAttribute("id", String.valueOf(characterID));
                                }
                                CharacterName.appendChild(document.createTextNode(name));
                                Character.appendChild(CharacterName);
                                Scene.appendChild(Character);

                                //Split Character String into speech
                                String str = act.text().substring(act.text().indexOf(".") + 1, act.text().length()).trim();

                                if (str.contains("[")) {
                                    //Split the string in Stage Directions and Speech
                                    String[] parts = str.split("(?<=])|(?=\\[)");

                                    for (String s : parts) {
                                        //STAGE DIRECTIONS
                                        if (s.contains("[")) {
                                            System.out.println("Stage Directions: " + s + "\n");
                                            StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                                            StageDirections.appendChild(document.createTextNode(s.replaceAll("\\[", "").replaceAll("\\]", "")));
                                            Character.appendChild(StageDirections);
                                            Scene.appendChild(Character);
                                        } else {
                                            //SPEECH
                                            s = s.trim();
                                            System.out.println("Speech: " + s + "\n");
                                            Speech = document.createElement("Λόγος");
                                            Speech.appendChild(document.createTextNode(s));
                                            Character.appendChild(Speech);
                                            Scene.appendChild(Character);
                                        }
                                    }
                                } else {
                                    //SPEECH ONLY
                                    System.out.println("Speech: " + str.trim() + "\n");
                                    Speech = document.createElement("Λόγος");
                                    Speech.appendChild(document.createTextNode(str.trim()));
                                    Character.appendChild(Speech);
                                    Scene.appendChild(Character);
                                }
                            }
                        }
                        Act.appendChild(Scene);
                    }
                    Play.appendChild(Act);
                    act = act.nextElementSibling();
                }
            } else if (actI != null) {
                System.out.println("\nACT I INSIDE <H2> FORMAT \n");
                //<H2> ELEMENT
                org.jsoup.nodes.Element act = actI.parent();

                //<P> ELEMENTS ONE AFTER ANOTHER
                while (!act.tagName().equals("pre")) {
                    //ACT
                    if (act.text().contains("ACT")) {
                        Act = document.createElement("Πράξη");
                        actNumber++;
                        System.out.println("Act " + actNumber + "\n");
                        Act.setAttribute("Νούμερο", String.valueOf(actNumber));
                        sceneNumber = 0;
                    }
                    //SCENE
                    if (act.text().contains("SCENE")) {
                        Scene = document.createElement("Σκηνή");
                        sceneNumber++;
                        System.out.println("Scene " + sceneNumber + "\n");
                        Scene.setAttribute("Νούμερο", String.valueOf(sceneNumber));
                        scenes++;
                    }
                    if (act.tagName().equals("blockquote")) {
                        //STAGE DIRECTIONS
                        org.jsoup.nodes.Element child = act.child(0);
                        while (child != null) {
                            System.out.println("Stage Directions: " + child.text() + "\n");
                            StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                            StageDirections.appendChild(document.createTextNode(child.text().replaceAll("\\[", "").replaceAll("\\]", "")));
                            if (Scene != null) {
                                Scene.appendChild(StageDirections);
                            } else {
                                Act.appendChild(StageDirections);
                            }
                            child = child.nextElementSibling();
                        }
                    }
                    if (act.tagName().equals("p") && act.hasText()) {
                        //STAGE DIRECTIONS
                        if (act.hasClass("scenedesc") || act.hasClass("right") || act.hasClass("nh")) {
                            System.out.println("Stage Directions: " + act.text() + "\n");
                            StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                            StageDirections.appendChild(document.createTextNode(act.text().replaceAll("\\[", "").replaceAll("\\]", "")));
                            if (Scene != null) {
                                Scene.appendChild(StageDirections);
                            } else {
                                Act.appendChild(StageDirections);
                            }
                        } else {
                            //CHARACTER
                            Character = document.createElement("Χαρακτήρας");
                            CharacterName = document.createElement("Όνομα");
                            //CHARACTER NAME
                            String fix = act.text().replaceAll("Hippolyta, I woo’d", "THESEUS. Hippolyta, I woo’d")
                                    .replaceAll("Helena, adieu", "LYSANDER. Helena, adieu").replaceAll("SNOUT", "SNOUT.")
                                    .replaceAll("SNUG", "SNUG.").replaceAll("ALL", "ALL.").replaceAll("FAIRY", "FAIRY.")
                                    .replaceAll("I’ll follow thee", "HELENA. I’ll follow thee").replaceAll("Hast thou the", "OBERON. Hast thou the")
                                    .replaceAll("Do it for thy", "OBERON. Do it for thy").replaceAll("Here comes my messenger", "OBERON. Here comes my messenger")
                                    .replaceAll("When thou wak’st, Thou", "PUCK. When thou wak’st, Thou").replaceAll("Be as thou wast", "OBERON. Be as thou wast")
                                    .replaceAll("Come, my queen", "OBERON. Come, my queen").replaceAll("We will, fair", "THESEUS. We will, fair")
                                    .replaceAll("Good morrow", "THESEUS. Good morrow").replaceAll("PROLOGUE", "PROLOGUE.")
                                    .replaceAll("Thanks, courteous", "PYRAMUS. Thanks, courteous").replaceAll("MOON", "MOON.")
                                    .replaceAll("Here she comes, and", "THESEUS. Here she comes, and").replaceAll("The iron tongue", "THESEUS. The iron tongue");
                            String name = fix.substring(0, fix.indexOf(".") + 1).replaceAll("\\.", "");
                            System.out.println("Character: " + name + "\n");
                            if (charList.contains(name)) {
                                id = charList.indexOf(name) + 1;
                                Character.setAttribute("id", String.valueOf(id));
                            } else {
                                charList.add(name);
                                characterID++;
                                Character.setAttribute("id", String.valueOf(characterID));
                            }
                            CharacterName.appendChild(document.createTextNode(name));
                            Character.appendChild(CharacterName);
                            if (Scene != null) {
                                Scene.appendChild(Character);
                            } else {
                                Act.appendChild(Character);
                            }

                            //Split Character String into speech
                            String str = act.text().substring(act.text().indexOf(".") + 1, act.text().length()).trim();

                            if (str.contains("[")) {
                                //Split the string in Stage Directions and Speech
                                String[] parts = str.split("(?<=])|(?=\\[)");

                                for (String s : parts) {
                                    //STAGE DIRECTIONS
                                    if (s.contains("[")) {
                                        System.out.println("Stage Directions: " + s + "\n");
                                        StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                                        StageDirections.appendChild(document.createTextNode(s.replaceAll("\\[", "").replaceAll("\\]", "")));
                                        Character.appendChild(StageDirections);
                                        if (Scene != null) {
                                            Scene.appendChild(StageDirections);
                                        } else {
                                            Act.appendChild(StageDirections);
                                        }
                                    } else {
                                        //SPEECH
                                        s = s.trim();
                                        System.out.println("Speech: " + s + "\n");
                                        Speech = document.createElement("Λόγος");
                                        Speech.appendChild(document.createTextNode(s));
                                        Character.appendChild(Speech);
                                        if (Scene != null) {
                                            Scene.appendChild(Character);
                                        } else {
                                            Act.appendChild(Character);
                                        }
                                    }
                                }
                            } else {
                                //SPEECH ONLY
                                System.out.println("Speech: " + str.trim() + "\n");
                                Speech = document.createElement("Λόγος");
                                Speech.appendChild(document.createTextNode(str.trim()));
                                Character.appendChild(Speech);
                                if (Scene != null) {
                                    Scene.appendChild(Character);
                                } else {
                                    Act.appendChild(Character);
                                }
                            }
                        }
                        if (Scene != null) {
                            Act.appendChild(Scene);
                        }
                    }
                    Play.appendChild(Act);
                    act = act.nextElementSibling();
                }
            } else if (actH2 != null && actH2.tagName().equals("h2")) {
                System.out.println("\nACT I THAT IS <H2> FORMAT \n");
                //<H2> ELEMENT
                org.jsoup.nodes.Element act = actH2;

                //<P> ELEMENTS ONE AFTER ANOTHER
                while (!act.tagName().equals("pre")) {
                    //ACT
                    if (act.text().contains("ACT ")) {
                        Act = document.createElement("Πράξη");
                        actNumber++;
                        System.out.println("Act " + actNumber + "\n");
                        Act.setAttribute("Νούμερο", String.valueOf(actNumber));
                        sceneNumber = 0;
                    }
                    if (act.tagName().equals("blockquote")) {
                        //STAGE DIRECTIONS
                        org.jsoup.nodes.Element child = act.child(0);
                        while (child != null) {
                            System.out.println("Stage Directions: " + child.text() + "\n");
                            StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                            StageDirections.appendChild(document.createTextNode(child.text().replaceAll("\\[", "").replaceAll("\\]", "")));
                            Act.appendChild(StageDirections);
                            child = child.nextElementSibling();
                        }
                    }
                    if (act.tagName().equals("p") && act.hasText()) {
                        //STAGE DIRECTIONS
                        if (act.hasClass("nh")) {
                            System.out.println("Stage Directions: " + act.text() + "\n");
                            StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                            StageDirections.appendChild(document.createTextNode(act.text().replaceAll("\\[", "").replaceAll("\\]", "")));
                            Act.appendChild(StageDirections);
                        } else if (act.tagName().equals("h3")) {
                            //STAGE DIRECTIONS
                            if (act.text().equals("CURTAIN")) {
                                System.out.println("Stage Directions: " + act.text() + "\n");
                                StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                                StageDirections.appendChild(document.createTextNode(act.text().replaceAll("\\[", "").replaceAll("\\]", "")));
                                Act.appendChild(StageDirections);
                            }
                        } else {
                            //CHARACTER
                            Character = document.createElement("Χαρακτήρας");
                            CharacterName = document.createElement("Όνομα");
                            //CHARACTER NAME
                            String fix = act.text().replaceAll("Physician", "Physician.").replaceAll("Madhav", "Madhav.")
                                    .replaceAll("Amal", "Amal.").replaceAll("First Boy", "First Boy.").replaceAll("Dairyman", "Dairyman.")
                                    .replaceAll("Boys", "Boys.").replaceAll("Gaffer", "Gaffer.").replaceAll("Fakir", "Fakir.")
                                    .replaceAll("Doctor", "Doctor.").replaceAll("Voice", "Voice.").replaceAll("Headman", "Headman.");
                            fix = fix.replaceAll("\\..", "\\.");
                            String name = fix.substring(0, fix.indexOf(".") + 1).replaceAll("\\.", "");
                            System.out.println("Character: " + name + "\n");
                            if (charList.contains(name)) {
                                id = charList.indexOf(name) + 1;
                                Character.setAttribute("id", String.valueOf(id));
                            } else {
                                charList.add(name);
                                characterID++;
                                Character.setAttribute("id", String.valueOf(characterID));
                            }
                            CharacterName.appendChild(document.createTextNode(name));
                            Character.appendChild(CharacterName);
                            Act.appendChild(Character);

                            //Split Character String into speech
                            String str = act.text().substring(act.text().indexOf(".") + 1, act.text().length()).trim();

                            if (str.contains("[")) {
                                //Split the string in Stage Directions and Speech
                                String[] parts = str.split("(?<=])|(?=\\[)");

                                for (String s : parts) {
                                    //STAGE DIRECTIONS
                                    if (s.contains("[")) {
                                        System.out.println("Stage Directions: " + s + "\n");
                                        StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                                        StageDirections.appendChild(document.createTextNode(s.replaceAll("\\[", "").replaceAll("\\]", "")));
                                        Character.appendChild(StageDirections);
                                        Act.appendChild(StageDirections);
                                    } else {
                                        //SPEECH
                                        s = s.trim();
                                        System.out.println("Speech: " + s + "\n");
                                        Speech = document.createElement("Λόγος");
                                        Speech.appendChild(document.createTextNode(s));
                                        Character.appendChild(Speech);
                                        Act.appendChild(Character);
                                    }
                                }
                            } else {
                                //SPEECH ONLY
                                System.out.println("Speech: " + str.trim() + "\n");
                                Speech = document.createElement("Λόγος");
                                Speech.appendChild(document.createTextNode(str.trim()));
                                Character.appendChild(Speech);
                                Act.appendChild(Character);
                            }
                        }
                    }
                    Play.appendChild(Act);
                    act = act.nextElementSibling();
                }
            }

            /*
            
            //MASTER BUILDER & HAMLET
            org.jsoup.nodes.Element cont = scrape.select("body :contains(CONTENTS  )").first();
            if (cont != null) {
                cont = cont.nextElementSibling();
                //MASTER BUILDER
                if (cont.tagName().equals("table")) {
                    for (org.jsoup.nodes.Element e : cont.select("p")) {
                        Elements contents = e.select("a");
                        System.out.println(contents.text());
                        Contents.appendChild(document.createTextNode(contents.text()));
                    }
                    //HAMLET
                } else if (cont.tagName().equals("p")) {
                    org.jsoup.nodes.Element contents = cont;
                    System.out.println(contents.text());
                    Contents.appendChild(document.createTextNode(contents.text()));
                }
            }
            

            //INTRODUCTION           
            org.jsoup.nodes.Element intro = scrape.select("body :contains(INTRODUCTION)").last();

            //MASTER BUILDER
            if (intro != null) {
                System.out.println("INTRODUCTION: ");
                System.out.println("\n");
                //Everything between 2nd <hr> and 3rd <hr>
                //Elements intro = scrape.select("hr:nth-of-type(2) ~ *:not(hr:nth-of-type(3) ~ *)");
                Introduction = document.createElement("Εισαγωγή");

                while (!intro.tagName().equals("h1")) {
                    //Check if element type is <p>
                    if (intro.tagName().equals("p")) {
                        if (!intro.hasText()) {
                            break;
                        } else {
                            System.out.println("Notes: " + intro.text() + "\n");
                            //Notes insert to XML
                            Element Notes = document.createElement("Σχόλιο");
                            Notes.appendChild(document.createTextNode(intro.text()));
                            Introduction.appendChild(Notes);
                        }
                    }
                    //Check if element type is <pre>
                    if (intro.tagName().equals("pre")) {
                        if (!intro.hasText()) {
                            break;
                        } else {
                            System.out.println("Excerpts: " + intro.text() + "\n");
                            Element Excerpts = document.createElement("Απόσπασμα");
                            Excerpts.appendChild(document.createTextNode(intro.text()));
                            Introduction.appendChild(Excerpts);
                        }
                    }
                    intro = intro.nextElementSibling();
                }
                Play.appendChild(Introduction);
                System.out.println("\n" + "------------------------------------------" + "\n");
            } else {
                System.out.println("NO INTRODUCTION " + "\n");
                System.out.println("\n" + "------------------------------------------" + "\n");
            }

            
            //MASTER BUILDER
            org.jsoup.nodes.Element c = scrape.select("body :contains(CHARACTERS.  )").first();
            //MASTER BUILDER
            if (c != null) {
                c = c.child(0);
                Elements chars = new Elements();

                while (!c.text().contains("ACT FIRST") && c.hasText()) {
                    chars.add(c);
                    c = c.nextElementSibling();
                }
                for (org.jsoup.nodes.Element e : chars) {
                    System.out.println(e.text().trim());
                    Characters = document.createElement("Χαρακτήρες");
                    //Characters insert to XML
                    Characters.appendChild(document.createTextNode(e.text()));
                }
                Play.appendChild(Characters);
                System.out.println("\n" + "------------------------------------------" + "\n");
            }


            //MASTER BUILDER
            org.jsoup.nodes.Element act1 = scrape.select("div.play").first();
            
            //MASTER BUILDER
            if (act1 != null) {
                org.jsoup.nodes.Element act = act1.child(0);
                while (!act.tagName().equals("h2")) {
                    act = act.nextElementSibling();
                }
                //Until last element
                while (act != null) {
                    //ACT
                    if (act.tagName().equals("h2")) {
                        Act = document.createElement("Πράξη");
                        System.out.println("ACT " + actNumber);
                        System.out.println("\n");
                        actNumber++;
                        Act.setAttribute("Νούμερο", String.valueOf(actNumber));
                    }
                    //Create Text Node
                    org.jsoup.nodes.TextNode actNode = (org.jsoup.nodes.TextNode) act.nextSibling();

                    //EXCERPT
                    if (act.tagName().equals("pre")) {
                        System.out.println("Excerpt: " + act.text() + "\n");
                        String ex = act.text().replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\r*\n*", "").replaceAll("       ", "");
                        Excerpt = document.createElement("Απόσπασμα");
                        Excerpt.appendChild(document.createTextNode(ex));
                        Act.appendChild(Excerpt);
                    }
                    //CHARACTER
                    if (act.tagName().equals("p")) {
                        if (act.text().contains("[")) {
                            //Split the string into Stage Directions and Speech 
                            String[] parts = act.text().split("(?<=])|(?=\\[)");
                            for (String s : parts) {
                                //STAGE DIRECTIONS
                                if (s.contains("[")) {
                                    s = s.trim();
                                    System.out.println("Stage Directions: " + s + "\n");
                                    StageDirections = document.createElement("Σκηνικές_Οδηγίες");
                                    StageDirections.appendChild(document.createTextNode(s.replaceAll("\\[", "").replaceAll("\\]", "")));
                                    Character.appendChild(StageDirections);
                                    Act.appendChild(Character);
                                } else {
                                    //SPEECH
                                    s = s.replaceAll("—", "").trim();
                                    System.out.println("Speech: " + s + "\n");
                                    Speech = document.createElement("Λόγος");
                                    Speech.appendChild(document.createTextNode(s));
                                    Character.appendChild(Speech);
                                    Act.appendChild(Character);
                                }
                            }
                        } else {
                            //SPEECH ONLY
                            String speech = act.text().replaceAll("—", "").trim();
                            System.out.println("Speech: " + speech + "\n");
                            Speech = document.createElement("Λόγος");
                            Speech.appendChild(document.createTextNode(speech));
                            Character.appendChild(Speech);
                            Act.appendChild(Character);
                        }
                    }
                    //CHARACTER NAME
                    if (!actNode.isBlank()) {
                        String name = actNode.text().replaceAll("\\.", "").trim();
                        System.out.println("Character: " + name + "\n");
                        Character = document.createElement("Χαρακτήρας");
                        CharacterName = document.createElement("Όνομα");
                        if (charList.contains(name)) {
                            id = charList.indexOf(name) + 1;
                            Character.setAttribute("id", String.valueOf(id));
                        } else {
                            charList.add(name);
                            characterID++;
                            Character.setAttribute("id", String.valueOf(characterID));
                        }
                        CharacterName.appendChild(document.createTextNode(name));
                        Character.appendChild(CharacterName);
                        Act.appendChild(Character);
                    }
                    Play.appendChild(Act);
                    System.out.println("\n" + "------------------------------------------" + "\n");
                    act = act.nextElementSibling();
                }
                rootElement.appendChild(Play);
            } else {
                System.out.println("NO MASTER BUILDER " + "\n");
                System.out.println("\n" + "------------------------------------------" + "\n");
            }
             */
            rootElement.appendChild(Play);
            System.out.println(charList);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            //Xml encoding property
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            //Xml indentation property
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            DOMSource source = new DOMSource(document);

            //Convert to String
            StringWriter writer = new StringWriter();
            StreamResult result = new StreamResult(writer);
            transformer.transform(source, result);
            //Print output to string
            String output = writer.toString().replaceAll("�", "-").replaceAll("&amp;", "");

            //Create file name
            myXMLFile = new File("file.xml");
            //Write XML to file
            PrintWriter pw = null;
            try {
                //Clear file contents
                pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(myXMLFile, false), StandardCharsets.UTF_8));
                //Write to file
                pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(myXMLFile, true), StandardCharsets.UTF_8));
                pw.println(output);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
            }
            pw.flush();
            pw.close();

            //Read myXMLFile to determine the line number
            NumberedFile = new File("NumberedFile.txt");
            int lineNumber = 1;
            BufferedReader br = null;
            try {
                //Read file
                br = new BufferedReader(new InputStreamReader(new FileInputStream(myXMLFile), StandardCharsets.UTF_8));
                String line = br.readLine();
                while (line != null) {
                    //Read next line
                    line = br.readLine();
                    lineNumber++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            br.close();

            //Write line numbers to NumberedFile
            int line = 1;
            BufferedWriter bw = null;
            try {
                //Clear file contents
                bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(NumberedFile, false), StandardCharsets.UTF_8));
                //Write to file
                bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(NumberedFile, true), StandardCharsets.UTF_8));
                for (int i = 1; i <= lineNumber; i++) {
                    //4 digit numbers
                    bw.write(String.format("%4d", line));
                    bw.newLine();
                    line++;
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            bw.close();

            //Create Line numbers TextPane
            lineNumbers = new JTextPane();
            lineNumbers.setEditable(false);

            //Set Background Color
            Color bgColor = Color.lightGray;
            UIDefaults defaults = new UIDefaults();
            defaults.put("TextPane.background", new ColorUIResource(bgColor));
            defaults.put("TextPane[Enabled].backgroundPainter", bgColor);
            lineNumbers.putClientProperty("Nimbus.Overrides", defaults);
            lineNumbers.putClientProperty("Nimbus.Overrides.InheritDefaults", true);
            lineNumbers.setBackground(bgColor);

            //Line numbers right-aligned
            SimpleAttributeSet rightAlign = new SimpleAttributeSet();
            StyleConstants.setAlignment(rightAlign, StyleConstants.ALIGN_RIGHT);
            lineNumbers.setParagraphAttributes(rightAlign, true);

            //Load line numbers on TextPane
            FileReader reader = new FileReader(NumberedFile);
            lineNumbers.read(reader, NumberedFile);

            Document d = XMLEditorPane.getDocument();
            //Add Document Listener
            d.addDocumentListener(new DocumentListener() {
                @Override
                public void changedUpdate(DocumentEvent e) {
                    //lineNumbers();
                }

                @Override
                public void insertUpdate(DocumentEvent e) {
                    //lineNumbers();
                }

                @Override
                public void removeUpdate(DocumentEvent e) {
                    //lineNumbers();
                }
            });
            //Set main component in XMLScrollPane
            XMLScrollPane.getViewport().add(XMLEditorPane);
            //Add lineNumbers as RowHeader on the left side of XMLEditorPane
            XMLScrollPane.setRowHeaderView(lineNumbers);
            XMLScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

            //Create XMLEditorKit
            XMLEditorKit xmlkit = new XMLEditorKit();
            XMLEditorPane.setEditorKit(xmlkit);
            //Load file on XMLEditorPane
            XMLEditorPane.setText(output);
            //Set the font style
            XMLEditorPane.setFont(new Font("Courier", Font.PLAIN, 12));
            //Set the tab size
            XMLEditorPane.getDocument().putProperty(PlainDocument.tabSizeAttribute, new Integer(4));
            //Enable auto indentation.
            xmlkit.setAutoIndentation(true);
            //Enable tag completion.
            xmlkit.setTagCompletion(true);
            //Enable error highlighting.
            XMLEditorPane.getDocument().putProperty(XMLEditorKit.ERROR_HIGHLIGHTING_ATTRIBUTE, new Boolean(true));
            //Set a style
            xmlkit.setStyle(XMLStyleConstants.ATTRIBUTE_NAME, new Color(255, 0, 0), Font.BOLD);
            XMLPanel.add(new XMLFoldingMargin(XMLEditorPane), BorderLayout.EAST);
            XMLPanel.add(new LineNumberMargin(XMLEditorPane), BorderLayout.WEST);

        } catch (ParserConfigurationException | TransformerException | IOException e) {
            e.printStackTrace();
        }
    }

    public int wordCounter(String s) {
        int counter = 0;
        String[] words = s.split("\\s");
        counter = words.length;
        //System.out.println("Words: " + Arrays.toString(words));
        //System.out.println("Word count: " + counter);
        return counter;
    }

    private String
            parseDocument(String text
            ) {
        String processedText
                = text;
// Remove <meta> tags

        processedText
                = processedText
                        .replaceAll("<meta([\\s\\S]+?)>", "");
        // Replace unknown characters with End of guarded area
        processedText
                = processedText
                        .replaceAll("�", "—");

        return processedText;

    }

    public static String
            wrap(java.lang.String str,
                    int wrapLength,
                    java.lang.String newLineStr,
                    boolean wrapLongWords
            ) {
        return str;

    }

    //Load MySQL JDBC driver
    static {
        try {
            Class
                    .forName("com.mysql.jdbc.Driver");

        } catch (ClassNotFoundException ex) {
            System.err
                    .println("Driver not found: " + ex
                            .getMessage());

        }
    }

    ;

    public static void main(String args[]) throws IOException {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info
                    : javax.swing.UIManager
                            .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info
                        .getName())) {
                    javax.swing.UIManager
                            .setLookAndFeel(info
                                    .getClassName());

                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger
                    .getLogger(LiteratureAnalyticsUI.class
                            .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger
                    .getLogger(LiteratureAnalyticsUI.class
                            .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger
                    .getLogger(LiteratureAnalyticsUI.class
                            .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger
                    .getLogger(LiteratureAnalyticsUI.class
                            .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue
                .invokeLater(new Runnable() {
                    public void run() {
                        new LiteratureAnalyticsUI().setVisible(true);

                    }
                });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> ActAnalysisList;
    private javax.swing.JScrollPane ActAnalysisScrollPane;
    private javax.swing.JLabel ActsLabel;
    private javax.swing.JButton AnalysisButton;
    private javax.swing.JPanel AnalysisPanel;
    private javax.swing.JList<String> CharacterAnalysisList;
    private javax.swing.JScrollPane CharacterAnalysisScrollPane;
    private javax.swing.JLabel CharacterLabel;
    private javax.swing.JCheckBox CrossPercentCheckBox;
    private javax.swing.JCheckBox CrossTabsCheckBox;
    private javax.swing.JList<String> DataList;
    private javax.swing.JButton DatabaseButton;
    private javax.swing.JButton DatabasePlaysButton;
    private javax.swing.JPanel FilteringPanel;
    private javax.swing.JEditorPane HTMLEditorPane;
    private javax.swing.JLabel HTMLLabel;
    private javax.swing.JPanel HTMLPanel;
    private javax.swing.JScrollPane HTMLScrollPane;
    private javax.swing.JButton ImportButton;
    private javax.swing.JCheckBox InfoCheckBox;
    private javax.swing.JCheckBox PlayCrossPercentCheckBox;
    private javax.swing.JCheckBox PlayCrossTabsCheckBox;
    private javax.swing.JButton PlayInfoButton;
    private javax.swing.JLabel PlayLabel;
    private javax.swing.JPanel PlayListPanel;
    private javax.swing.JScrollPane PlayListScrollPane;
    private javax.swing.JLabel PlaySearchLabel;
    private javax.swing.JTextField PlaySearchTextField;
    private javax.swing.JCheckBox PlayStatisticsCheckBox;
    private javax.swing.JLabel PlayURLLabel;
    private javax.swing.JCheckBox PlayWordCountCheckBox;
    private javax.swing.JList<String> PlaysList;
    private javax.swing.JLabel PlaysListLabel;
    private javax.swing.JComboBox<String> PlotComboBox;
    private javax.swing.JButton SaveButton;
    private javax.swing.JList<String> SceneAnalysisList;
    private javax.swing.JScrollPane SceneAnalysisScrollPane;
    private javax.swing.JLabel ScenesLabel;
    private javax.swing.JButton SortPlaysButton;
    private javax.swing.JSplitPane SplitPane;
    private javax.swing.JPanel TopPanel;
    private javax.swing.JCheckBox WordCountCheckBox;
    private javax.swing.JEditorPane XMLEditorPane;
    private javax.swing.JLabel XMLLabel;
    private javax.swing.JPanel XMLPanel;
    private javax.swing.JScrollPane XMLScrollPane;
    private javax.swing.JButton XMLValidationButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
