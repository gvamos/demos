package demoserver

@Grab('com.github.albaker:GroovySparql:0.6')
import groovy.sparql.*

class SparqlService {

    def queryTXT(String query) {
        def sparql = new Sparql(endpoint:"http://dbpedia.org/sparql")
        def out = ''
        def newline = System.getProperty("line.separator")
        sparql.each query, {
            out += "${s} : ${p} : ${o}${newline}"
        }
        return out
    }

    def queryCSV(String query) {
        def sparql = new Sparql(endpoint:"http://dbpedia.org/sparql")
        def out = ''
        def newline = System.getProperty("line.separator")
        sparql.each query, {
            out += "\"${s}\",\"${p}\",\"${o}\"${newline}"
        }
        return out
    }

    def queryJSON(String query) {
        def sparql = new Sparql(endpoint:"http://dbpedia.org/sparql")
        def out = []
        sparql.each query, {
            out << ["${s}", "${p}", "${o}"]
        }
        return out
    }

    def writeJSON(String query, String filename) {
        def result = queryJSON(query)
        def output = result as grails.converters.JSON
        output.prettyPrint = true
        File file = new File(filename)
        if (file.exists()) {
            file.delete()
        }
        file << output
    }

}
