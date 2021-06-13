
# try this?
# the below expression is copy pasted from
# https://gist.github.com/zouzias/2ad84c6325e6c8a96e40eabe78e07170
# s/^.\(.*\).$/\1/

#for i in "$@"
#do
	#sed -i 's/\\n/\n/g' "$i"
  #sed -i 's/^.\(.*\).$/\1/' "$i"
  #sed -i 's/"/**//**/g' "$i"
  #sed -i 's/};"/};/g' "$i"
#done
# should do newline replacement
# on each of input files
# thru the command line

# https://stackoverflow.com/questions/1224766/how-do-i-rename-the-extension-for-a-bunch-of-files
for file in *.txt
do
  mv "$file" "${file%.txt}.cpp"
done
# thank you to Matthias Braun and ghostdog74, this is their code, not mine