rm -rf *.class inputs/*.out
javac *java

for file in inputs/*; do
  java Main $file "$file.out"
done

