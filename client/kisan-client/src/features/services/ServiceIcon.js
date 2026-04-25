export default function ServiceIcon({ src, alt }) {
  return (
    <img
      src={src}
      alt={alt}
      style={{
        width: '120px',
        height: '100px',
        objectFit: 'contain',
        marginBottom: '20px',
      }}
    />
  );
}