------------------------------------------------------------------------
This is the project README file. Here, you should describe your project.
Tell the reader (someone who does not know anything about this project)
all he/she needs to know. The comments should usually include at least:
------------------------------------------------------------------------

PROJECT TITLE:Online Job seeking system
PURPOSE OF PROJECT: Job listing and seeking platform
VERSION or DATE: 
HOW TO START THIS PROJECT:
AUTHORS: Aravind Nagaraj
USER INSTRUCTIONS:

Platform: Windows User
This project will be using an embedded database as a means of storing data called as HSQLDB. 
The server must be started prior to using the system.
1) Extract the zip file (HSQLDB) to "C:\" directory.
2) In the command prompt ( Power shell ) type the following post zipping the file.
"C:c\>cd hsqldb-2.4.0\hsqldb"
3) Copy the next line onto the command prompt after changing to directory ( CD)
"java -classpath lib/hsqldb.jar org.hsqldb.server.Server --database.0 file:hsqldb/monashojss --dbname.0 ojssdb"
4) If the server runs without error, run the package from blueJ 