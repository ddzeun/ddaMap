import { CSSProperties } from 'react';

interface Station {
    stnId: string;
    stnName: string;
    address: string;
    distance: number;
    latitude: number;
    longitude: number;
}

interface StationDetailProps {
    station: Station;
    onClose: () => void;
}

export default function StationDetail({ station, onClose }: StationDetailProps) {
    const panelStyle: CSSProperties = {
        position: 'absolute',
        bottom: '85px',
        left: '16px',
        right: '16px',
        backgroundColor: 'white',
        borderRadius: '20px',
        boxShadow: '0 -4px 20px rgba(0, 0, 0, 0.12)',
        padding: '24px',
        boxSizing: 'border-box',
        zIndex: 100,
        transition: 'transform 0.3s ease-in-out',
        transform: 'translateY(0)',
    };

    const headerStyle: CSSProperties = {
        display: 'flex',
        justifyContent: 'space-between',
        alignItems: 'flex-start',
        marginBottom: '16px',
    };

    const closeButtonStyle: CSSProperties = {
        width: '32px',
        height: '32px',
        border: 'none',
        borderRadius: '50%',
        backgroundColor: '#f5f5f5',
        cursor: 'pointer',
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'center',
        fontSize: '18px',
        color: '#666',
        flexShrink: 0,
    };

    const titleStyle: CSSProperties = {
        fontSize: '22px',
        fontWeight: 'bold',
        color: '#222',
        marginBottom: '8px',
        flex: 1,
        marginRight: '12px',
    };

    const addressStyle: CSSProperties = {
        fontSize: '14px',
        color: '#666',
        marginBottom: '16px',
        lineHeight: '1.5',
    };

    const distanceBoxStyle: CSSProperties = {
        display: 'inline-flex',
        alignItems: 'center',
        gap: '6px',
        backgroundColor: '#f0f8ff',
        padding: '8px 14px',
        borderRadius: '12px',
        fontSize: '14px',
        color: '#1e88e5',
        fontWeight: '500',
    };

    const iconStyle: CSSProperties = {
        width: '16px',
        height: '16px',
    };

    const dividerStyle: CSSProperties = {
        height: '1px',
        backgroundColor: '#e0e0e0',
        margin: '16px 0',
    };

    const actionButtonStyle: CSSProperties = {
        width: '100%',
        padding: '14px',
        backgroundColor: '#1e88e5',
        color: 'white',
        border: 'none',
        borderRadius: '12px',
        fontSize: '16px',
        fontWeight: '600',
        cursor: 'pointer',
        marginTop: '12px',
    };

    return (
        <div style={panelStyle}>
            <div style={headerStyle}>
                <div>
                    <h2 style={titleStyle}>{station.stnName}</h2>
                    <p style={addressStyle}>{station.address}</p>
                </div>
                <button onClick={onClose} style={closeButtonStyle}>
                    ✕
                </button>
            </div>
            
            <div style={distanceBoxStyle}>
                <svg style={iconStyle} viewBox="0 0 24 24" fill="none" stroke="currentColor">
                    <path d="M21 10c0 7-9 13-9 13s-9-6-9-13a9 9 0 0 1 18 0z" strokeWidth="2" strokeLinecap="round" strokeLinejoin="round" />
                    <circle cx="12" cy="10" r="3" strokeWidth="2" />
                </svg>
                내 위치에서 {Math.floor(station.distance)}m
            </div>

            <div style={dividerStyle}></div>

            <button style={actionButtonStyle}>
                길안내
            </button>
        </div>
    );
}