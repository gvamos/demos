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

}
