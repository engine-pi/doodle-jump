deploy:
	mvn deploy

doc: install
	rm -rf target/site/apidocs
	mvn javadoc:javadoc
	xdg-open target/site/apidocs/index.html

format:
	mvn process-sources

install:
	mvn install

package:
	mvn package

.PHONY: deploy doc format install package
