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
        if (!params.filename) {
            flash.error = "No filename entered."
            render(view: "query", model: [query: params.query, filename: params.filename, output: params.output])
            return
        }
        Report report = Report.findByFilename(params.filename)
        if (!report) {
            report = new Report(params)
            report.save(flush: true)
        }
        sparqlService.writeJSON(params.query)
        flash.message = "Report published to ${params.filename}."
        redirect(action: "query")
    }

}
