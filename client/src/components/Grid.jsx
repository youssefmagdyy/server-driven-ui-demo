
const Grid = ({ data }) => (
  <div style={{ display: "flex", gap: "1rem", flexWrap: "wrap", padding: "1rem", justifyContent: "center" }}>
    {data.map((product) => (
      <div
        key={product.ID}
        style={{
          border: "1px solid #ccc",
          padding: "1rem",
          width: "200px",
          textAlign: "center",
        }}
      >
        {product.IMAGE_URL ? (
          <img src={product.IMAGE_URL} alt={product.NAME} width="100%" />
        ) : (
          <div style={{ height: "100px", background: "#f0f0f0" }}>No Image</div>
        )}
        <h3>{product.NAME}</h3>
        <p>{product.PRODUCER}</p>
      </div>
    ))}
  </div>
);

export default Grid;
