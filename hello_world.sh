personal_info() {
  echo "You provided $# facts about yourself!"
  echo "Your name is $1"
  echo "Your age is $2"
#  echo $@
}
personal_info "Andrew" 19
