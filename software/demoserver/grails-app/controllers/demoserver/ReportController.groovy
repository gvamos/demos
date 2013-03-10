package demoserver

import groovy.json.*

class ReportController {
    static scaffold = true

    def sparqlService

    def test() {
        def query = "SELECT ?s ?p ?o WHERE { ?s ?p ?o } LIMIT 6"
        def output = sparqlService.queryJSON(query)
        render(output as grails.converters.JSON)
    }

    def query() {
        def output
        if (params.query) {
            def result = sparqlService.queryJSON(params.query)
            output = result as grails.converters.JSON
            output.prettyPrint = true
        }
        [query: params.query, filename: params.filename, output: output]
    }

    def publish() {
        File file = new File(params.filename)
        Report report = new Report(params)
        report.save(flush: true)
        file << params.output
        flash.message = "Report published to ${params.filename}."
        redirect(action: "query")
    }

}
