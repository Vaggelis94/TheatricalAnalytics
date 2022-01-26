# LiteratureAnalytics
A desktop app for data analysis of theatrical plays.

The app loads a list of plays from the online library Project Guternberg.
Clicking on a play will load the file in the middle section of the app while creating an XML file containing data of the play via HTML scraping.
Due to the wide range of HTML structure of the plays, the app won't load every single one of them but the code can be expanded
so that it includes more. (The first ones on top of the list should be working)
Also some text in the plays requires cleaning so that the data can be as accurate as possible.
The XML file on the right side is validated against an XSD file (plays.xsd) which is crucial for the validity and structure of the data.
Once the XML file is valid, that data can be stored in a database which in turn will produce tables and load them on the lower part of the app.
Finally the user can see statistics, numbers and graphs based on the data of their choice. 


