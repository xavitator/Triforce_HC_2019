rm -rf *.class inputs/*.sc
javac *java

for file in inputs/*; do
  java Main $file "$file.sc"
done

