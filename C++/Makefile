
_RED=$(shell tput setaf 1 2> /dev/null || echo "")
_GREEN=$(shell tput setaf 2 2> /dev/null || echo "")
_YELLOW=$(shell tput setaf 3 2> /dev/null || echo "")
_BLUE=$(shell tput setaf 4 2> /dev/null || echo "")
_PURPLE=$(shell tput setaf 5 2> /dev/null || echo "")
_CYAN=$(shell tput setaf 6 2> /dev/null || echo "")
_WHITE=$(shell tput setaf 7 2> /dev/null || echo "")
_END=$(shell tput sgr0 2> /dev/null || echo "")

NAME = progcpp

CXX = g++
CXX_FLAGS = -O2 -Wall -Wextra -Werror \
			-Wshadow -Wnon-virtual-dtor -Wold-style-cast -Wcast-align \
			-Wunused -Woverloaded-virtual -pedantic
CXX_STD = -std=c++11
INC_FLAGS = -I ./
FLAGS = $(CXX_FLAGS) $(CXX_STD) $(INC_FLAGS)

SRC = \
		main.cpp \

OBJ = $(SRC:%.cpp=%.o)

.PHONY: all
all: $(NAME)

$(NAME): $(OBJ)
	@printf "Program %s... " "$(NAME)"
	@$(CXX) $(FLAGS) $(OBJ) -o $(NAME)
	@printf "%scompiled%s\\n" "$(_CYAN)" "$(_END)"

%.o: %.cpp
	@printf "Compiling %s... " "$?"
	@$(CXX) $(FLAGS) -c $? -o $@
	@printf "%scompiled%s\\n" "$(_GREEN)" "$(_END)"

.PHONY: clean
clean:
	@echo "Objects removed"
	@rm -rf $(OBJ)

.PHONY: fclean
fclean: clean
	@echo "Program $(NAME) removed"
	@rm -rf $(NAME)

.PHONY: re
re: fclean all
