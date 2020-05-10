# FKPayrollDesign
Everyday the payroll function (option 7) should be run by the admin,
which will take account of time cards and Sales Receipt and union charges(if any) of that day and will calculate salary for each day. 
It will add each day salary until the day comes when employee should receive salary as per the problem.
It will output what amount to be paid to which employee on the current day according to the company's polocies.

All the actions are being formed by running Payroll.java.
Commands to run :
      1. for compilation : "javac -cp .:/home/pranav/Desktop/FKPayrollDesign/SourceCode/json-simple-1.1.1.jar Payroll.java -d ClassFiles/"
      2. for execution   : "java -cp .:/home/pranav/Desktop/FKPayrollDesign/SourceCode/json-simple-1.1.1.jar:ClassFiles/ Payroll"
      3. for printing employee data on terminal : "cat employees.json | json_reformat"

After execution it will ask for following options:
      Adding a new employee : press 1 and hit enter
      Firing an employee : press 2 and hit enter
      Changing data of an employee : press 3 and hit enter
      Post Time Card of an employee : press 4 and hit enter
      Post Sales Recipt of an employee : press 5 and hit enter
      Post union dues of an employee : press 6 and hit enter
      Run payroll : press 7 and hit enter
Choose the desired option and follow the instructions shown in terminal.
For more details read Documentation.
