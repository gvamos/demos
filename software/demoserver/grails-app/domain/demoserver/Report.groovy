package demoserver

class Report {

    String filename
    String query
    Date dateCreated, lastUpdated

    static constraints = {
        filename()
        query()
    }
}
