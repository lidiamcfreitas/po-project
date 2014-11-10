# $Id: Makefile,v 1.2 2011/09/25 14:49:09 david Exp $

JAVADIR=/Users/Armstrong/Bank_
JARNAME=po-bank-support

all:
	(cd src; javac -encoding UTF-8 -cp $(JAVADIR)/po-uilib.jar `find . -name \*.java`)
	(cd src; jar cvf ../$(JARNAME).jar `find . -name \*.class -o -name \*.java`)

clean:
	$(RM) $(JARNAME).jar `find . -name \*.class`
