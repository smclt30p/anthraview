execute:
	cp src/dist/build.gradle .
	cp src/dist/build.number .
	mkdir tmp
	gradle build
clean:
	rm build.gradle
	rm build.number
	rm -r build/
	rm -r tmp/
	rm Makefile
install:
	cd tmp
	cp build/distributions/anthraview-1.0.tar tmp/.
	cp src/dist/anthraview tmp/.
	tar -vxf tmp/anthraview-1.0.tar -C tmp/.
	mkdir /lib/anthraview/
	cp tmp/anthraview-1.0/lib/*.jar /lib/anthraview/.
	cp tmp/anthraview /bin/anthraview
	chmod 0644 /bin/anthraview
	chmod +x /bin/anthraview
uninstall:
	rm -r /lib/anthraview
	rm -r /bin/anthraview
