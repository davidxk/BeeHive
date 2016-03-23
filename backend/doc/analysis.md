###Function
* the server receives data from the quadrotor 
* saves it on the server
* analyses it
* and presents the raw data with the analysed result on a web when called upon

That's a few classes

###Class
* SaveServelet: retrieves the data from <form> and saves it
* Report: the set of env data at a certain time point(model)
* ReportDAO: deals with data persistence
* DisplayServlet: reads the data and calculates for presentation
* Statistician: calculates the statistics


####SaveServelet
* reads out the data from <form> according to agreed key protocol
* initiate a Report object with given data
* saves the data with ReportDAO save(report)

> ######Protocol
* the first three letters

####Report
* a model class with only getter and setter methods

>######members
* co1
* temperature
* humidity
* gps
* timestamp

####ReportDAO
* void save(Report report)
* List<Report> get(int nRecords)

####RetrieveServlet
* calls on get(n)
* calculate the statistics with Statistician
* make the list acquirable by front end

####Statistician
* Report average(List<Report> reportList)
* Report variance(List<Report> reportList)
* Report range(List<Report> reportList)