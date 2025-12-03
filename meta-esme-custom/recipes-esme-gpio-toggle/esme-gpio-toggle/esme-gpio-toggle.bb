# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# Unable to find any files that looked like license statements. Check the accompanying
# documentation and source headers and set LICENSE and LIC_FILES_CHKSUM accordingly.
#
# NOTE: LICENSE is being set to "CLOSED" to allow you to at least start building - if
# this is not accurate with respect to the licensing of the software being built (it
# will not be in most cases) you must specify the correct value before using this
# recipe for anything other than initial testing/development!
LICENSE = "CLOSED"
LIC_FILES_CHKSUM = ""

# No information for SRC_URI yet (only an external source tree was specified)
SRC_URI = "git://github.com/romanemahesme/esme-gpio-toggle.git;protocol=https;branch=main"
SRCREV = "50f1a6ea612fed201709c46eb7f544501e3a1741"
S = "${WORKDIR}/git"

# Héritage de la classe pour gérer pkg-config (Question 13)
inherit pkgconfig update-rc.d

# Dépendance vers la librairie libgpiod version inférieure à 2.0 (Question 13)
DEPENDS = "libgpiod (< 2.0)"
# NOTE: this is a Makefile-only piece of software, so we cannot generate much of the
# recipe automatically - you will need to examine the Makefile yourself and ensure
# that the appropriate arguments are passed in.

INITSCRIPT_PACKAGES = "${PN}"
INITSCRIPT_NAME:${PN} = "esme-gpio26-toggle"

do_configure () {
	# Specify any needed configure commands here
	:
}

do_compile () {
	# You will almost certainly need to add additional arguments here
	oe_runmake
}

do_install () {
	oe_runmake install INSTALL_DIR=${D}
}

