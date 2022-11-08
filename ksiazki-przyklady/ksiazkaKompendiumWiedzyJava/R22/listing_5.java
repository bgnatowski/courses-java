// Uwaga - to jedynie fragment kodu, nie uda się go skompilować w takiej postaci
for(int h=0; h < 3; h++) {
  // Zapisuje bajty w buforze
  for(int i=0; i<26; i++)
  mBuf.put((byte)('A' + i));

  // Zeruje pozycję w buforze, aby można było zapisać jego zawartość
  mBuf.rewind();

  // Zapisuje zawartość bufora w pliku wyjściowym
  fChan.write(mBuf);

  // Zeruje pozycję w buforze, aby można było ponownie zapisać jego zawartość
  mBuf.rewind();
}
