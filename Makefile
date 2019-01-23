
.PHONY: all
all: help

.PHONY: help
help:
	@printf "make missing : print what is done, and what is missing\\n"

.PHONY: missing
missing:
	@bash scripts/missing.sh
