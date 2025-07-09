export default function StationDetail({ station, onClose}) {

    const panelStyle = {
        position: 'absolute',
        bottom: '35px',
        left: '26px',
        right: '26px',
        height: '20vh',
        backgroundColor: 'white',
        borderRadius: '12px',
        boxShadow: '0 -2px 10px rgba(0, 0, 0, 0.15)',
        padding: '20px',
        boxSizing: 'border-box',
        zIndex: 100,
        transition: 'transform 0.3s ease-in-out',
        transform: 'translateY(0)',
    };

    return (
        <div style={panelStyle}>
            <button onClick={onClose}>X</button>
            <h2>{station.stnName}</h2>
            <p>{station.address}</p><p>내 위치에서 {parseInt(station.distance)}m</p>
        </div>
    )
}