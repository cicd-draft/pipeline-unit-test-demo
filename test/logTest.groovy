class logGroovyTest extends PipelineSpecification {

    def log

    def setup() {
        log = loadScript("vars/log.groovy")
    }

    def 'log info'() {
        when:
        log.info("info message")
        then:
        helper.methodCallCount("info") == 1
        helper.callStack.find {call -> call.methodName == 'info'}.args[0] == 'info message'
    }

    def 'log warn'() {
        when:
        log.warn('warn message')
        then:
        helper.methodCallCount('warn') == 1
        helper.callStack.find {call -> call.methodName == 'warn'}.args[0] == 'warn message'
    }
}